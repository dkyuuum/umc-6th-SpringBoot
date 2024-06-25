package com.example.umc.service.MemberMissionService;

import com.example.umc.domain.Mission;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.MemberMissionRequestDTO;

import java.util.List;

public interface MemberMissionCommandService {
    void addMissionToMember(Long memberId, Long missionId);
    List<MemberMission> getMissionList(Long memberId);
}
