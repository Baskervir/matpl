package com.example.matpl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    public void sendSignupConfirmationEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("회원가입 완료 안내");
        message.setText("안녕하세요!\n\n회원가입이 정상적으로 완료되었습니다.\n\n서비스를 이용해 주셔서 감사합니다!");

        try {
            mailSender.send(message);
            log.info("회원가입 완료 메일 발송 성공: {}", toEmail);
        } catch (Exception e) {
            log.error("메일 전송 실패: {}", e.getMessage());
        }
    }
}
