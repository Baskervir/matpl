package com.example.matpl.usecase;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.mail.SendVerficationEmailService;
import com.example.matpl.service.SignupService;
import com.example.matpl.validator.DuplicateValidator;
import com.example.matpl.validator.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class SignupUseCase {
    private final DuplicateValidator duplicateValidator;
    private final PasswordValidator passwordValidator;
    private final SignupService signupService;
    private final SendVerficationEmailService sendVerficationEmailService;

    public void execute(UserDTO userDTO) {
        duplicateValidator.emailValidate(userDTO.getEmail());
        duplicateValidator.nicknameValidate(userDTO.getNickname());
        passwordValidator.validate(userDTO.getPassword(), userDTO.getPasswordCheck());
        signupService.signup(userDTO);
        sendVerficationEmailService.sendEmail(userDTO.getEmail());
    }
}
