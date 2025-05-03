package com.example.matpl.adminRequest.usecase;

import com.example.matpl.adminRequest.service.AdminRequestUserSaveService;
import com.example.matpl.adminRequest.dto.AdminRequesterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AdminRequestUsecase {
    private final AdminRequestUserSaveService service;

    @Transactional
    public void requestAndSaveRequesterInfo(AdminRequesterDto dto) {
        service.saveAdminRequester(dto);

    }
}
