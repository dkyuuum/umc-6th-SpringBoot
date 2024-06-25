package com.example.umc.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
