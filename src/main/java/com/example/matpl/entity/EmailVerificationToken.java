package com.example.matpl.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "email_verification_token")
public class EmailVerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private String email;

    @Column
    private LocalDateTime expireDate;

    @Column
    private boolean verified;

    public void markAsVerified() {
        this.verified = true;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(this.expireDate);
    }
}
