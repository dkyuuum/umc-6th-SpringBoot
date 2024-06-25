package com.example.umc.service.StoreService;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Mission> getMissionList(Long storeId, Integer page);
}

