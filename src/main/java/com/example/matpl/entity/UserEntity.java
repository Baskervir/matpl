package com.example.matpl.entity;

import com.example.matpl.enums.Role;
import com.example.matpl.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column(unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'BASIC'")
    private Role role;

    public UserEntity(String email, String password, String nickname, UserStatus status) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = status;
    }

    public void verifiedUser() {
        this.status = UserStatus.VERIFIED;
    }
}
