package com.example.matpl.handler;

import com.example.matpl.exception.InvalidPasswordException;
import com.example.matpl.exception.UserAlreadyExistsException;
import com.example.matpl.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(UserAlreadyExistsException e) {
        log.error("AlreadyExists error: ", e);
        ApiResponse<Void> response = new ApiResponse<>(false, e.getMessage(), null);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(InvalidPasswordException e) {
        log.error("Validation error: ", e);
        ApiResponse<Void> response = new ApiResponse<>(false, e.getMessage(), null);
        return ResponseEntity.badRequest().body(response);
    }
}
