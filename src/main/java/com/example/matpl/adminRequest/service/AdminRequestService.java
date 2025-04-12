package com.example.matpl.adminRequest.service;

import com.example.matpl.adminRequest.dto.AdminRequestDto;
import com.example.matpl.adminRequest.entity.AdminRequestEntity;
import com.example.matpl.adminRequest.repository.AdminRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminRequestService {
    private final AdminRequestRepository adminRequestRepository;

    public void saveRequest(AdminRequestDto dto, String requesterEmail) {
        AdminRequestEntity request = AdminRequestEntity.builder()
                .requesterEmail(requesterEmail)
                .restaurantName(dto.getRestaurantName())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .description(dto.getDescription())
                .status("PENDING")
                .build();

        adminRequestRepository.save(request);
    }

    public boolean isPendingRequestExists(String requesterEmail) {
        return adminRequestRepository.existsByRequesterEmailAndStatus(requesterEmail, "PENDING");
    }
}
