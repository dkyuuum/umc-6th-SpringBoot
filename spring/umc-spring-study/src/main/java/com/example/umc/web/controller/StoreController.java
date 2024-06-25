package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MissionConverter;
import com.example.umc.converter.ReviewConverter;
import com.example.umc.converter.StoreConverter;
import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.repository.StoreRepository;
import com.example.umc.service.MissionService.MissionCommandService;
import com.example.umc.service.ReviewService.ReviewCommandService;
import com.example.umc.service.ReviewService.ReviewQueryService;
import com.example.umc.service.StoreService.StoreCommandService;
import com.example.umc.service.StoreService.StoreQueryService;
import com.example.umc.web.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final ReviewCommandService reviewCommandService;
    private final StoreRepository storeRepository;
    private final StoreQueryService storeQueryService;
    private final MissionCommandService missionCommandService;

    @Operation(summary = "특정 가게 리뷰 등록 API")
    @PostMapping("/{storeId}/reviews/add")
    public ApiResponse<ReviewResponseDTO.PostResultDto> postReview(
            @RequestBody @Valid ReviewRequestDTO.PostDto request,
            @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "memberId") Long memberId
    ){
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Review review = reviewCommandService.postReview(memberId, store, request);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }

    @Operation(summary = "특정 가게 미션 등록 API")
    @PostMapping("/{storeId}/missions/add")
    public ResponseEntity<ApiResponse<MissionRequestDTO.AddResultDto>> addMissionToStore(
            @PathVariable Long storeId,
            @Valid @RequestBody MissionResponseDTO.MissionPreViewDTO requestDTO) {

        Mission mission = missionCommandService.addMissionToStore(storeId, requestDTO);
        MissionRequestDTO.AddResultDto responseDTO = MissionConverter.toResponseDTO(mission);

        return ResponseEntity.ok(ApiResponse.onSuccess(responseDTO));
    }

    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<ReviewListDTO.ReviewPreViewListDTO> getReviewList(
            @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page
    ){
        Page<Review> reviewPage = storeQueryService.getReviewList(storeId, page);
        ReviewListDTO.ReviewPreViewListDTO reviewListResultDTO = StoreConverter.toReviewPreViewListDTO(reviewPage);

        return ApiResponse.onSuccess(reviewListResultDTO);
    }

    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(
            @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page
    ){
        Page<Mission> missionPage = storeQueryService.getMissionList(storeId, page);
        MissionResponseDTO.MissionPreViewListDTO missionRequestDTO = StoreConverter.toMissionPreViewListDTO(missionPage);

        return ApiResponse.onSuccess(missionRequestDTO);
    }

}