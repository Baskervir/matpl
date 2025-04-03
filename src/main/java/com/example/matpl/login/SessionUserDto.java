package com.example.matpl.login;

public class SessionUserDto {
    private final String nickname;

    public SessionUserDto(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}