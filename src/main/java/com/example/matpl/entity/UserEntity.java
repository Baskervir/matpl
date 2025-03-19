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
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
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

    public UserEntity(String email, String password, String passwordCheck, String nickname) {
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.nickname = nickname;
    }


    @PrePersist
    public void setDefaultRole() {
        if (this.role == null) {
            this.role = Role.BASIC;
        }
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordCheck='" + passwordCheck + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role=" + role +
                '}';
    }
}
