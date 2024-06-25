package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.MemberMissionRequestDTO;
import com.example.umc.web.dto.MemberMissionResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMissionConverter {

    public static MemberMission toEntity(MemberMissionRequestDTO postDto, Member member, Mission mission) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionResultDto toDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionResultDto.builder()
                .id(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(String.valueOf(MissionStatus.CHALLENGING))
                .build();
    }

    public static List<MemberMissionResponseDTO.MemberMissionResultDto> toDTO(List<MemberMission> memberMissions) {
        return memberMissions.stream()
                .map(MemberMissionConverter::toDTO)
                .collect(Collectors.toList());
    }
}
