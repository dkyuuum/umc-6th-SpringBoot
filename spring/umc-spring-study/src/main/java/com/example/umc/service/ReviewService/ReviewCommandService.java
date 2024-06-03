package com.example.umc.service.ReviewService;

import com.example.umc.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public String postReview(ReviewRequestDTO.PostDto reviewRequestDTO, long storeId);
}
