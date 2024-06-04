package com.example.umc.web.dto;

import com.example.umc.domain.enums.MissionStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class MemberMissionRequestDto {
        @NotNull
        private int memberId;

        @NotNull
        private int missionId;

        private MissionStatus missionStatus;
    }
}
