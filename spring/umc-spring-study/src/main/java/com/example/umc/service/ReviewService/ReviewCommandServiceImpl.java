package com.example.umc.service.ReviewService;

import com.example.umc.converter.ReviewConverter;
import com.example.umc.domain.Member;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.ReviewRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
     private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    public Review postReview(Long memberId, Store store, ReviewRequestDTO.PostDto request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Review review = Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .rate(request.getRate())
                .store(store)
                .member(member)
                .build();

        return reviewRepository.save(review);
    }

}



