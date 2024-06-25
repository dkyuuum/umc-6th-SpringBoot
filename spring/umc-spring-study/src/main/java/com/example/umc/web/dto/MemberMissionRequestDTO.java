package com.example.umc.web.dto;

import com.example.umc.domain.enums.MissionStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MemberMissionRequestDTO {
    @NotNull
    private Long memberId;

    @NotNull
    private Long missionId;

    private MissionStatus missionStatus;
}
