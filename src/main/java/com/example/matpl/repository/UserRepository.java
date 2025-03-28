package com.example.matpl.repository;

import com.example.matpl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    void deleteByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
