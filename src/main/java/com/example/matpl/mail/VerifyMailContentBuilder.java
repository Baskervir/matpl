package com.example.matpl.mail;

public interface VerifyMailContentBuilder {
    String buildSubject();
    String buildContentWithToken(String token);
}
