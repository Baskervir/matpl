package com.example.matpl.repository;

import com.example.matpl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

//    Optional<UserEntity> findByVerificationToken(String token);
}
