package com.example.umc.web.controller;

import com.example.umc.converter.MemberMissionConverter;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.service.MemberMissionService.MemberMissionCommandService;
import com.example.umc.web.dto.MemberMissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MemberConverter;
import com.example.umc.domain.Member;
import com.example.umc.service.MemberService.MemberCommandService;
import com.example.umc.web.dto.MemberRequestDTO;
import com.example.umc.web.dto.MemberResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionCommandService memberMissionService;

    @Operation(summary = "회원가입(간략화) API")
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MemberRequestDTO.JoinDto request
    ) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @Operation(summary = "가게 미션 도전 API")
    @PostMapping("/{memberId}/missions/{missionId}/add")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDto> addMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId
    ) {
        memberMissionService.addMissionToMember(memberId, missionId);
        return ApiResponse.onSuccess(null);
    }

    @Operation(summary = "도전 중인 미션 목록 조회 API")
    @GetMapping("/{memberId}/missions")
    public ApiResponse<List<MemberMissionResponseDTO.MemberMissionResultDto>> getMemberMissionList(
            @PathVariable Long memberId
    ) {
        List<MemberMission> missionList = memberMissionService.getMissionList(memberId);
        List<MemberMissionResponseDTO.MemberMissionResultDto> memberMissionResultDto = MemberMissionConverter.toDTO(missionList);
        return ApiResponse.onSuccess(memberMissionResultDto);
    }
}
