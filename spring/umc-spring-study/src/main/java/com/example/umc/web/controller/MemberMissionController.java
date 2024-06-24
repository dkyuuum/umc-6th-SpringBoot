package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MemberMissionConverter;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.service.MemberMissionService.MemberMissionCommandService;
import com.example.umc.web.dto.MemberMissionRequestDTO;
import com.example.umc.web.dto.MemberMissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionService;

    @Operation(summary = "가게 미션 도전 API")
    @PostMapping("/{memberId}/missions/add")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDto> addMission(
            @PathVariable int memberId
        ) {
        memberMissionService.getMissionChallenging(memberId);
        return ApiResponse.onSuccess(null);
    }
}


