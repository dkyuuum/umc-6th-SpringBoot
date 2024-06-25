package com.example.umc.service.ReviewService;

import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.ReviewRequestDTO;
import com.example.umc.web.dto.StoreRequestDTO;
import org.hibernate.query.Page;

public interface ReviewCommandService {
    Review postReview(
            Long memberId,
            Store store,
            ReviewRequestDTO.PostDto reviewRequestDTO
    );

}
