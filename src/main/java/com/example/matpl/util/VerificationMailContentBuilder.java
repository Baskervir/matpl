package com.example.matpl.util;

import org.springframework.stereotype.Component;

@Component
public class VerificationMailContentBuilder implements MailContentBuilder {
    @Override
    public String buildSubject() {
        return "[MATPL] 이메일 인증 요청";
    }

    @Override
    public String buildContent(String... token) {
        String verifyUrl = "http://localhost:8080/verify?token=" + token;
        return "<h2>회원가입 이메일 인증</h2>" +
                "<p>아래 버튼을 클릭하여 이메일 인증을 완료해주세요.</p>" +
                "<a href='" + verifyUrl + "' " +
                "style='display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none;'>" +
                "이메일 인증하기</a>";
    }
}
