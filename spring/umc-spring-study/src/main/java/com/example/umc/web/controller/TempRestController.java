package com.example.umc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.TempConverter;
import com.example.umc.service.TempService.TempQueryService;
import com.example.umc.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
