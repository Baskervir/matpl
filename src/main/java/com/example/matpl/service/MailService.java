package com.example.matpl.service;

import com.example.matpl.repository.UserRepository;
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
    private final UserRepository userRepository;

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

//    public void sendVerificationEmail(UserEntity user) {
//        String token = UUID.randomUUID().toString();
//        user.setVerificationToken(token);
//        user.setStatus(UserStatus.UNVERIFIED); // 기본 상태 설정
//        userRepository.save(user); // 토큰 저장
//
//        String verifyUrl = "http://localhost:8080/verify?token=" + token;
//
//        String content = "<h2>회원가입 이메일 인증</h2>" +
//                "<p>아래 버튼을 클릭하여 이메일 인증을 완료해주세요.</p>" +
//                "<a href='" + verifyUrl + "' " +
//                "style='display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none;'>" +
//                "이메일 인증하기</a>";
//
//        try {
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//            helper.setTo(user.getEmail());
//            helper.setSubject("[MATPL] 이메일 인증 요청");
//            helper.setText(content, true); // HTML true
//
//            mailSender.send(message);
//            System.out.println("인증 메일 전송 완료");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            throw new RuntimeException("메일 전송 실패");
//        }
//    }
}
