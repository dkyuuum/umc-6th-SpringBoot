package com.example.umc.converter;

import com.example.umc.domain.Mission;
import com.example.umc.web.dto.MissionRequestDTO;
import com.example.umc.web.dto.MissionResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public static MissionRequestDTO.AddResultDto toResponseDTO(Mission mission) {
        new MissionRequestDTO.AddResultDto();
        return MissionRequestDTO.AddResultDto.builder()
                    .id(mission.getId())
                    .title(mission.getTitle())
                    .description(mission.getDescription())
                    .rewardPoints(mission.getReward())
                    .createdAt(mission.getCreatedAt())
                    .build();
    }
}

