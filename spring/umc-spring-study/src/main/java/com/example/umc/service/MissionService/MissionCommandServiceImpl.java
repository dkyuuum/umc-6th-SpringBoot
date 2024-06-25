package com.example.umc.service.MissionService;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import com.example.umc.repository.MissionRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.MissionRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

     @Override
    @Transactional
    public Mission addMissionToStore(Long storeId, MissionRequestDTO requestDTO) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + storeId));

        Mission mission = Mission.builder()
                .title(requestDTO.getTitle())
                .description(requestDTO.getDescription())
                .reward(requestDTO.getRewardPoints())
                .store(store)
                .build();

        return missionRepository.save(mission);
    }
}
