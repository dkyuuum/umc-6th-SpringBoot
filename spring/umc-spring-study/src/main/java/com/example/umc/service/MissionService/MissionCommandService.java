package com.example.umc.service.MissionService;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import com.example.umc.web.dto.MissionRequestDTO;
import com.example.umc.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    Mission addMissionToStore(Long storeId, MissionResponseDTO.MissionPreViewDTO requestDTO);
}
