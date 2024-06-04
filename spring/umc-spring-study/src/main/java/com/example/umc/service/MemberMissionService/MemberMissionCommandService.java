package com.example.umc.service.MemberMissionService;

import com.example.umc.domain.Mission;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public void getMissionChallenging(int memberId);
}
