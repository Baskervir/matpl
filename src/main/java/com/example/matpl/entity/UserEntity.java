package com.example.matpl.entity;

import com.example.matpl.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column
    private String password;

    @Column
    private String passwordCheck;

    @Column(unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'BASIC'")
    private Role role;

    public UserEntity(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }
}
