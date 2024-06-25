package com.example.umc.converter;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import com.example.umc.web.dto.MissionRequestDTO;
import com.example.umc.web.dto.ReviewListDTO;
import com.example.umc.web.dto.StoreRequestDTO;
import com.example.umc.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static MissionRequestDTO.MissionPreViewDTO toMissionPreViewDTO(Mission mission) {
        return MissionRequestDTO.MissionPreViewDTO.builder()
                .title(mission.getTitle())
                .description(mission.getDescription())
                .rewardPoints(mission.getReward())
                .build();
    }

    public static MissionRequestDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> missionPage) {
        List<MissionRequestDTO.MissionPreViewDTO> missionPreViewDTOList = missionPage.stream()
                .map(StoreConverter::toMissionPreViewDTO)
                .toList();

        return MissionRequestDTO.MissionPreViewListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .build();
    }

     public static ReviewListDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return ReviewListDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rate(review.getRate())
                .body(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewListDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewPage) {
        List<ReviewListDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewPage.stream()
                .map(StoreConverter::toReviewPreViewDTO)
                .collect(Collectors.toList());

        return ReviewListDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}