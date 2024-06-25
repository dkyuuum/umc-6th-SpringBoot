package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MissionConverter;
import com.example.umc.domain.Mission;
import com.example.umc.service.MissionService.MissionCommandService;
import com.example.umc.web.dto.MissionRequestDTO;
import com.example.umc.web.dto.MissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @Operation(summary = "특정 가게 미션 등록 API")
    @PostMapping("/{storeId}/missions/add")
    public ResponseEntity<ApiResponse<MissionResponseDTO.AddResultDto>> addMissionToStore(
            @PathVariable Long storeId,
            @Valid @RequestBody MissionRequestDTO requestDTO) {

        Mission mission = missionCommandService.addMissionToStore(storeId, requestDTO);
        MissionResponseDTO.AddResultDto responseDTO = MissionConverter.toResponseDTO(mission);

        return ResponseEntity.ok(ApiResponse.onSuccess(responseDTO));
    }
}
