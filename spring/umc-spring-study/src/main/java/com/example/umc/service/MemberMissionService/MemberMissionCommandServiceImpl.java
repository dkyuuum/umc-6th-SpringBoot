package com.example.umc.service.MemberMissionService;

import com.example.umc.converter.MemberMissionConverter;
import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.repository.MemberMissionRepository;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.MissionRepository;
import com.example.umc.web.dto.MemberMissionRequestDTO;
import com.example.umc.web.dto.MemberMissionResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public void getMissionChallenging(int memberId) {
        MemberMission memberMission = memberMissionRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member mission ID"));
        memberMission.setStatus(MissionStatus.CHALLENGING);
        memberMissionRepository.save(memberMission);
    }
}
