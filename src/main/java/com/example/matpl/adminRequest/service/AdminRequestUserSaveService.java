package com.example.matpl.adminRequest.service;

import com.example.matpl.adminRequest.dto.AdminRequesterDto;
import com.example.matpl.adminRequest.emum.AdminRequestStatus;
import com.example.matpl.adminRequest.entity.AdminRequestEntity;
import com.example.matpl.adminRequest.repository.AdminRequestUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminRequestUserSaveService {
    private final AdminRequestUserRepository repository;

    public void saveAdminRequester(@Valid AdminRequesterDto dto) {
        AdminRequestEntity requester = AdminRequestEntity.builder()
                .restaurantName(dto.getRestaurantName())
                .ownerName(dto.getOwnerName())
                .ownerPhone(dto.getOwnerPhone())
                .restaurantAddress(dto.getRestaurantAddress())
                .requesterMessage(dto.getRequestMessage())
                .status(AdminRequestStatus.PENDING)
                .build();

        repository.save(requester);
    }
}
