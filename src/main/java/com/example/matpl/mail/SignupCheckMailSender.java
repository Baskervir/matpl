package com.example.matpl.mail;

import org.springframework.stereotype.Component;

@Component
public class SignupCheckMailSender implements MailContentBuilder {
    @Override
    public String buildSubject() {
        return "[MATPL] 회원 가입이 완료되었습니다.";
    }

    @Override
    public String buildContent() {
        return "<h2>회원 가입을 축하드립니다.</h2>" +
                "<p>인증 성공! \uD83C\uDF89</p>" +
                "<p>이제 모든 기능을 정상적으로 이용하실 수 있습니다.</p>" +
                "<p>감사합니다. 좋은 하루 보내세요!</p>";
    }
}
