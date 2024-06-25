package com.example.umc.web.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class StoreDTO{
        @NotBlank
        String title;
        @NotNull
        Double rate;
        @NotBlank
        String content;

        @Id
        private int storeId;
    }
}