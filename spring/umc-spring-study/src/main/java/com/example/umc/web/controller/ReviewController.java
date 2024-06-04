package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.ReviewConverter;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.repository.StoreRepository;
import com.example.umc.service.ReviewService.ReviewCommandService;
import com.example.umc.web.dto.ReviewRequestDTO;
import com.example.umc.web.dto.ReviewResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final StoreRepository storeRepository; // StoreRepository 추가

    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResponseDTO.PostResultDto> postReview(
            @PathVariable int storeId,
            @Valid @RequestBody ReviewRequestDTO.PostDto postDto)
    {
        Store store = storeRepository.findById(storeId).orElse(null);
        Review review = reviewCommandService.postReview(postDto, store);

        return ApiResponse.onSuccess(ReviewConverter.toPostResultDTO(review));
    }
}
