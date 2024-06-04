package com.example.umc.service.MissionService;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import com.example.umc.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMissionToStore(int storeId, MissionRequestDTO requestDTO);
}
