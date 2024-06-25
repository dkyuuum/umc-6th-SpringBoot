package com.example.umc.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResultDto{
        private Long id;
        private String title;
        private String description;
        private int rewardPoints;
        LocalDateTime createdAt;
    }
}
