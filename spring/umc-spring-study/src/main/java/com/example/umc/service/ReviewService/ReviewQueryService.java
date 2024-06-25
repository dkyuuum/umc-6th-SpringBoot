package com.example.umc.service.ReviewService;

import com.example.umc.domain.Review;
import org.hibernate.query.Page;

import java.util.List;

public interface ReviewQueryService {
        List<Review> getReviewsByMemberId(Long memberId);
}
