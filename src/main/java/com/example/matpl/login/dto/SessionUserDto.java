package com.example.matpl.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SessionUserDto {
    private String email;
    private String nickname;
}