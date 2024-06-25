package com.example.umc.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import com.example.umc.validation.annotation.ExistCategories;
import java.util.List;

@Getter
@Setter
public class MemberRequestDTO {

    @NotBlank
    private String name;

    @NotNull
    private int gender;

    @NotNull
    private int birthYear;

    @NotNull
    private int birthMonth;

    @NotNull
    private int birthDay;

    @Size(min = 5, max = 12)
    private String address;

    @Size(min = 5, max = 12)
    private String specAddress;

    @ExistCategories
    private List<Long> preferCategory;
}
