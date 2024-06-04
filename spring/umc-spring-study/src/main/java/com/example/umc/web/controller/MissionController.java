package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MissionConverter;
import com.example.umc.domain.Mission;
import com.example.umc.service.MissionService.MissionCommandService;
import com.example.umc.web.dto.MissionRequestDTO;
import com.example.umc.web.dto.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}/missions")
    public ResponseEntity<ApiResponse<MissionResponseDTO.AddResultDto>> addMissionToStore(
            @PathVariable int storeId,
            @Valid @RequestBody MissionRequestDTO requestDTO) {

        Mission mission = missionCommandService.addMissionToStore(storeId, requestDTO);
        MissionResponseDTO.AddResultDto responseDTO = MissionConverter.toResponseDTO(mission);

        return ResponseEntity.ok(ApiResponse.onSuccess(responseDTO));
    }
}
