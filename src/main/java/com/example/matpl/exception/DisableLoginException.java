package com.example.matpl.exception;

public class DisableLoginException extends RuntimeException {
    public DisableLoginException(String message) {
        super(message);
    }
}
