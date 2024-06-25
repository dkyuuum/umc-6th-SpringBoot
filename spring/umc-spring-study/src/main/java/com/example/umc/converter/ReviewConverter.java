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

@Component
@Transactional
public class ReviewConverter {

      public static Review toReview(
              ReviewRequestDTO.PostDto request
      ){
        return Review.builder()
                .title(request.getTitle())
                .rate(request.getRate())
                .content(request.getContent())
                .build();
    }

    public static ReviewResponseDTO.PostResultDto toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.PostResultDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .rate(review.getRate())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
    }

}
