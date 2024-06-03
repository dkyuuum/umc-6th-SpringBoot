package com.example.umc.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class AddDto {
        @NotEmpty
        String description;

        @NotEmpty
        int point;
    }
}
