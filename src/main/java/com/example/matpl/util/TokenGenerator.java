package com.example.matpl.util;

import java.util.UUID;

public class TokenGenerator {
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
