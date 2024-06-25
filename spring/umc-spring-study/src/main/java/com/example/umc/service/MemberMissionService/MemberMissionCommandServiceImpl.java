package com.example.umc.service.MemberMissionService;

import com.example.umc.converter.MemberMissionConverter;
import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.repository.MemberMissionRepository;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.MissionRepository;
import com.example.umc.service.MemberMissionService.MemberMissionCommandService;
import com.example.umc.web.dto.MemberMissionRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Transactional
    public void getMissionChallenging(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member mission ID"));
        memberMission.setStatus(MissionStatus.CHALLENGING);
        memberMissionRepository.save(memberMission);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberMission> getMissionList(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당 회원 없음: " + memberId));
        return memberMissionRepository.findByMember(member);
    }

    @Transactional
    public void addMissionToMember(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당 회원 없음: " + memberId));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new EntityNotFoundException("해당 미션 없음: " + missionId));

        MemberMission memberMission = MemberMissionConverter.toEntity(new MemberMissionRequestDTO(), member, mission);
        memberMissionRepository.save(memberMission);
    }
}
