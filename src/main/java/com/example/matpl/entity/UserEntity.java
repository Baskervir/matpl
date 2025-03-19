package com.example.matpl.entity;

import com.example.matpl.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String password;

    @Column
    private String passwordCheck;

    @Column(unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'BASIC'")
    private Role role;

    public UserEntity(Object o, @Email(message = "올바른 이메일 주소를 입력하세요.") @NotBlank(message = "이메일을 입력하지 않았습니다.") String email, String encodedPassword, @NotBlank(message = "닉네임을 입력해주세요.") String nickname, Object o1) {
    }

    @PrePersist
    public void setDefaultRole() {
        if (this.role == null) {
            this.role = Role.BASIC;
        }
    }
}
