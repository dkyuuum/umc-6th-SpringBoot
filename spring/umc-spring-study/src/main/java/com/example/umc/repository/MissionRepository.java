package com.example.umc.repository;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
}

