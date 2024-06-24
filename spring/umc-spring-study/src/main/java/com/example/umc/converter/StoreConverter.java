package com.example.umc.converter;

import com.example.umc.domain.Review;
import com.example.umc.web.dto.ReviewListDTO;
import com.example.umc.web.dto.StoreRequestDTO;
import com.example.umc.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
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