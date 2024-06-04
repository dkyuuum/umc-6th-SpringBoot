package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.ReviewRequestDTO;
import com.example.umc.web.dto.ReviewResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReviewConverter {

    public static ReviewResponseDTO.PostResultDto toPostResultDTO(Review review) {
        return ReviewResponseDTO.PostResultDto.builder()
                .storeId(review.getStore().getId())
                .title(review.getTitle())
                .content(review.getContent())
                .rate(review.getRate())
                .createdAt(LocalDateTime.now())
                .build();
    }

     public static Review toReview(ReviewRequestDTO.PostDto request, Member member, Store store){
        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .rate(request.getRate())
                .member(member)
                .store(store)
                .build();
    }
}
