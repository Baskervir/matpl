package com.example.matpl.adminRequest.repository;

import com.example.matpl.adminRequest.entity.AdminRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRequestUserRepository extends JpaRepository<AdminRequestEntity, Long> {
}
