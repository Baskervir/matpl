package com.example.matpl.mail;

import com.example.matpl.util.TokenGenerator;
import org.springframework.stereotype.Service;


@Service
public class EmailVerificationService {
    public String createVerificationToken() {
        return TokenGenerator.generate();
    }
}
