package com.eng.planeng.exception;

public class LoginAlreadyInUseException extends RuntimeException {

    public LoginAlreadyInUseException(String message) {
        super(message);
    }
}
