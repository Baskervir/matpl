package com.example.matpl.mail;

import com.example.matpl.util.VerifyMailContentBuilder;
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
public class MailSendService {
    private final VerifyMailContentBuilder verifyMailContentBuilder;
    private final JavaMailSender mailSender;

    public void sendVerifyMail(String email, String token) {
        String subject = verifyMailContentBuilder.buildSubject();
        String content = verifyMailContentBuilder.buildContentWithToken(token);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            log.info("인증 메일 발송 성공: {}", email);
        } catch (MessagingException e) {
            log.info("메일 발송 실패" + e.getMessage());
        }

    }
}
