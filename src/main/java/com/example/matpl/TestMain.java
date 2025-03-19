package com.example.matpl;

import com.example.matpl.dto.UserDTO;

public class TestMain {
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");

        System.out.println("이메일: " + userDTO.getEmail());  // 정상 실행되면 Lombok 문제 없음
    }
}
