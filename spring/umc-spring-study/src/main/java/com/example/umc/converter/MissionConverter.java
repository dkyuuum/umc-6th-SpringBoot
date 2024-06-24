package com.example.umc.converter;

import com.example.umc.domain.Mission;
import com.example.umc.web.dto.MissionResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public static MissionResponseDTO.AddResultDto toResponseDTO(Mission mission) {
        MissionResponseDTO.AddResultDto responseDTO = new MissionResponseDTO.AddResultDto();
        responseDTO.setId(mission.getId());
        responseDTO.setTitle(mission.getTitle());
        responseDTO.setDescription(mission.getDescription());
        responseDTO.setRewardPoints(mission.getReward());

        return responseDTO;

    }
}

