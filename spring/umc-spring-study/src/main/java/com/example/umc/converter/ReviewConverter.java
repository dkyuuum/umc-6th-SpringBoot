package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.ReviewListDTO;
import com.example.umc.web.dto.ReviewRequestDTO;
import com.example.umc.web.dto.ReviewResponseDTO;
import org.hibernate.query.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class ReviewConverter {

    // 리뷰 등록
    public static ReviewResponseDTO.PostResultDto toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.PostResultDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .rate(review.getRate())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
    }

    public static List<ReviewResponseDTO.PostResultDto> toDTO(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toCreateReviewResultDTO)
                .collect(Collectors.toList());
    }

}
