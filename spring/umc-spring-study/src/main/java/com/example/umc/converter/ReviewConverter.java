package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.ReviewRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    public Review convertToEntity(ReviewRequestDTO.PostDto postDto, Member member, Store store) {
        return new Review(1L, postDto.getTitle(), postDto.getContent(), postDto.getRate(), member, store);
    }
}
