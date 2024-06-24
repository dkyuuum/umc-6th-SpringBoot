package com.example.umc.service.StoreService;

import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(int id);
    Page<Review> getReviewList(int storeId, Integer page);
}

