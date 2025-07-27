package com.jimmyproject.utils.exceptions;

public class AuthenticationException extends AppException {
    public AuthenticationException(String message) {
        super("AUTHENTICATION_ERROR", message);
    }
}
