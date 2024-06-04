package com.example.umc.web.dto;

import com.example.umc.domain.Member;
import com.example.umc.domain.Store;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class PostDto {
        @NotEmpty
        private String title;

        @NotEmpty
        private String content;

        @Min(value = 0)
        @Max(value = 5)
        private double rate;
    }
}
