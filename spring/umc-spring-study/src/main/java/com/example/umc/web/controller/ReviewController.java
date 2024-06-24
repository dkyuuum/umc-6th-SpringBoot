package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.ReviewConverter;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.repository.StoreRepository;
import com.example.umc.service.ReviewService.ReviewCommandService;
import com.example.umc.service.ReviewService.ReviewQueryService;
import com.example.umc.web.dto.ReviewListDTO;
import com.example.umc.web.dto.ReviewRequestDTO;
import com.example.umc.web.dto.ReviewResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final StoreRepository storeRepository;
    private final ReviewQueryService reviewQueryService;

    @Operation(summary = "특정 가게 리뷰 등록 API")
    @PostMapping("/{storeId}/add")
    public ApiResponse<ReviewResponseDTO.PostResultDto> postReview(
            @RequestBody @Valid ReviewRequestDTO.PostDto request,
            @PathVariable(name = "storeId") int storeId,
            @RequestParam(name = "memberId") int memberId
    ){
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Review review = reviewCommandService.postReview(memberId, store, request);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }

/*    @Operation(summary = "사용자가 작성한 리뷰 목록 조회 API")
    @GetMapping("/user/{memberId}")
    public ApiResponse<ReviewListDTO.ReviewPreViewListDTO> getUserReviewList(
            @PathVariable(name = "memberId") int memberId,
            @RequestParam(name = "page", defaultValue = "0") int page
    ){
        Page<Review> reviewPage = reviewQueryService.getUserReviewList(memberId, page);
        ReviewListDTO.ReviewPreViewListDTO reviewListResultDTO = ReviewConverter.toReviewPreViewListDTO(reviewPage);
        return ApiResponse.onSuccess(reviewListResultDTO);
    }*/
}
