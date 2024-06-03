package com.example.umc.web.controller;

import com.example.umc.service.ReviewService.ReviewCommandService;
import com.example.umc.web.dto.ReviewRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}")
    public ResponseEntity<String> postReview(
            @PathVariable long storeId,
            @Valid @RequestBody ReviewRequestDTO.PostDto postDto) {
        String reviewId = reviewCommandService.postReview(postDto, storeId);

        return ResponseEntity.ok(reviewId);
    }
}
