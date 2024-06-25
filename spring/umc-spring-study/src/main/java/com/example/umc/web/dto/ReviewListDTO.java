package com.example.umc.web.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewListDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO{
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO{
        String ownerNickname;
        Double rate;
        String body;
        LocalDate createdAt;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class ReviewDTO {
        private String title;
        private String content;
        private Double rate;
        private LocalDateTime createdAt;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class ReviewListResultDTO {
        private boolean isLast;
        private boolean isFirst;
        private int totalPage;
        private long totalElements;
        private int listSize;
        private List<ReviewDTO> reviewList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class CreateReviewResultDTO {
        private Long reviewId;
        private LocalDateTime createdAt;
    }

}
