package com.example.umc.service.ReviewService;

import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review postReview(
            ReviewRequestDTO.PostDto reviewRequestDTO,
            Store storeId
    );
}
