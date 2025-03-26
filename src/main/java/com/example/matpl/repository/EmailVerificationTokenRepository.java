    package com.example.matpl.repository;

    import com.example.matpl.entity.EmailVerificationToken;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long> {
        Optional<EmailVerificationToken> findByToken(String token);
    }
