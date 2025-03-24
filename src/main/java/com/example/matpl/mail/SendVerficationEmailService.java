package com.example.matpl.mail;

import com.example.matpl.repository.EmailVerificationTokenRepository;
import com.example.matpl.util.TokenGenerator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SendVerficationEmailService {
    private final JavaMailSender mailSender;

    public void sendEmail(String email) {
        String token = TokenGenerator.generate();
        String verifyUrl = "http://localhost:8080/verify?token=" + token;

        String content = "<h2>회원가입 이메일 인증</h2>" +
                "<p>아래 버튼을 클릭하여 이메일 인증을 완료해주세요.</p>" +
                "<a href='" + verifyUrl + "' " +
                "style='display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none;'>" +
                "이메일 인증하기</a>";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject("[MATPL] 이메일 인증 요청");
            helper.setText(content, true);

            mailSender.send(message);
            log.info("인증 메일 발송 성공: {}", email);
        } catch (MessagingException e) {
            log.error("메일 발송 실패", e);
            throw new RuntimeException("메일 발송 중 예외 발생", e); // or CustomException
        }
    }
}
