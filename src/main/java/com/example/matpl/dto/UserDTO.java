package com.example.matpl.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @Email(message = "올바른 이메일 주소를 입력하세요.")
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자리 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인란을 입력하세요.")
    private String passwordCheck;

    @NotBlank(message = "닉네임은 필수 입력값입니다.")
    private String nickname;

//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getPasswordCheck() { return passwordCheck; }
//    public void setPasswordCheck(String passwordCheck) { this.passwordCheck = passwordCheck; }
//
//    public String getNickname() { return nickname; }
//    public void setNickname(String nickname) { this.nickname = nickname; }
}
