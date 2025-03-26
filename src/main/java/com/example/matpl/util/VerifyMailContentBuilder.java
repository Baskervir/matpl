package com.example.matpl.util;

public interface VerifyMailContentBuilder {
    String buildSubject();
    String buildContentWithToken(String token);
}
