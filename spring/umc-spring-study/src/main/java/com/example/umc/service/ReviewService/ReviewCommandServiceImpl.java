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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewConverter reviewConverter;

    @Override
    @Transactional
    public String postReview(ReviewRequestDTO.PostDto postDto, long storeId) {
        Member member = memberRepository.getReferenceById(1L);
        Optional<Store> storeOptional = storeRepository.findById(storeId);

        if (storeOptional.isEmpty()) {
            throw new IllegalArgumentException("Store not found with id: " + storeId);
        }

        Store store = storeOptional.get();
        Review review = reviewConverter.convertToEntity(postDto, member, store);
        reviewRepository.save(review);
        return review.getId().toString();
    }
}