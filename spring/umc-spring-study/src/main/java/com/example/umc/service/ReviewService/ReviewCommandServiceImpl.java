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

    @Override
    @Transactional
    public Review postReview(ReviewRequestDTO.PostDto postDto, Store store) {
        Member member = memberRepository.getReferenceById(1);
        Optional<Store> storeOptional = storeRepository.findById(store.getId());

        Store s = storeOptional.get();
        Review review = ReviewConverter.toReview(postDto, member, s);
        reviewRepository.save(review);

        return reviewRepository.save(review);
    }
}
