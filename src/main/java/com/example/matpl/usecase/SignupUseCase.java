package com.example.matpl.usecase;

import com.example.matpl.dto.UserDto;
import com.example.matpl.service.SignupService;
import com.example.matpl.validator.DuplicateUserInfoValidator;
import com.example.matpl.validator.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class SignupUseCase {
    private final DuplicateUserInfoValidator duplicateUserInfoValidator;
    private final PasswordValidator passwordValidator;
    private final SignupService signupService;
    private final SignupMailVerificationUseCase signupMailVerificationUseCase;

    public void execute(UserDto userDTO) {
        duplicateUserInfoValidator.emailValidate(userDTO.getEmail());
        duplicateUserInfoValidator.nicknameValidate(userDTO.getNickname());
        passwordValidator.validate(userDTO.getPassword(), userDTO.getPasswordCheck());

        signupService.signup(userDTO);

        signupMailVerificationUseCase.execute(userDTO);
    }
}
