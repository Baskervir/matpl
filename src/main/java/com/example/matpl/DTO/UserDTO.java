package com.example.matpl.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    @Email
    private String userEmail;
}
