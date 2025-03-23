package com.example.matpl.config;

import com.example.matpl.entity.UserEntity;
import com.example.matpl.enums.Role;
import com.example.matpl.repository.UserRepository;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RootUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (!userRepository.existsByEmail("matplrm@gmail.com")) {
            UserEntity rootUser = UserEntity.builder()
                    .email("matplrm@gmail.com")
                    .password("matpl@root")
                    .nickname("루트관리자")
                    .role(Role.ROOT)
                    .build();

            userRepository.save(rootUser);
            System.out.println("root 관리자 계정 생성 완료");
        } else {
            System.out.println("root 계정은 이미 존재합니다.");
        }
    }

    @PreDestroy
    public void onShutdown() {
        if (userRepository.existsByEmail("matplrm@gmail.com")) {
            userRepository.deleteByEmail("matplrm@gmail.com");
            System.out.println("root 관리자 계정 삭제 완료");
        }
    }
}
