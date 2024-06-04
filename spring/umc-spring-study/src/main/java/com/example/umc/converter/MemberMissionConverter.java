package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MemberStatus;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.MemberMissionRequestDTO;
import com.example.umc.web.dto.MemberMissionResponseDTO;
import com.example.umc.web.dto.MissionRequestDTO;
import com.example.umc.web.dto.MissionResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberMissionConverter {

    public static MemberMission toEntity(MemberMissionRequestDTO.MemberMissionRequestDto postDto, Member member, Mission mission) {
        return MemberMission.builder()
                .status(postDto.getMissionStatus())
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionResultDto toDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionResultDto.builder()
                .id(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }

}
