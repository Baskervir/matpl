package com.example.matpl.usecase;

import com.example.matpl.mail.MailSendService;
import com.example.matpl.service.TokenStoreService;
import com.example.matpl.util.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignupMailVerificationUseCase {
    private final TokenGenerator tokenGenerator;
    private final MailSendService mailSendService;
    private final TokenStoreService tokenStoreService;

    public void execute() {
        String token = tokenGenerator.generate();
    }
}
