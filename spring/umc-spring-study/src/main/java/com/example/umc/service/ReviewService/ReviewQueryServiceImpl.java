package com.example.umc.service.ReviewService;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.exception.handler.TempHandler;
import com.example.umc.domain.Review;
import com.example.umc.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

//    public Page<Review> getUserReviewList(int memberId, int page) {
//        return reviewRepository.findByMemberId(memberId, PageRequest.of(page, 10));
//    }

}
