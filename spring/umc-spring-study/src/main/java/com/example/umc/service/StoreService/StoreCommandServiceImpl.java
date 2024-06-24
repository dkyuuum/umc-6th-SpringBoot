package com.example.umc.service.StoreService;

import com.example.umc.converter.StoreConverter;
import com.example.umc.domain.Review;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.ReviewRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

}