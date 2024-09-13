package com.eng.planeng.exception;

import com.eng.planeng.dto.error.ErrorDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST,
                        Objects.requireNonNull(exception.getFieldError()).getDefaultMessage())
                );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<ErrorDTO> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(
                        HttpStatus.BAD_REQUEST,
                        "Database error: Some required fields are missing or invalid."
                ));
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    private ResponseEntity<ErrorDTO> handleAuthenticationFailedException(AuthenticationFailedException exception) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorDTO(HttpStatus.UNAUTHORIZED, exception.getMessage()));
    }

    @ExceptionHandler(LoginAlreadyInUseException.class)
    private ResponseEntity<ErrorDTO> handleLoginAlreadyInUseException(LoginAlreadyInUseException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    private ResponseEntity<ErrorDTO> handleBadCredentialsException(BadCredentialsException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST, "Invalid login or password"));
    }
}
