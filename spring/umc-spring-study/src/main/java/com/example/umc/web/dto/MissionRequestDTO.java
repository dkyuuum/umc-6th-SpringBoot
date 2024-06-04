package com.example.umc.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;

@Data
public class MissionRequestDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Positive
    private int rewardPoints;
}
