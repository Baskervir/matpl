package com.example.matpl.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenGenerator {
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
