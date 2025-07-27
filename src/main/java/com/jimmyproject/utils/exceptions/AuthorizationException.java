package com.jimmyproject.utils.exceptions;

public class AuthorizationException extends AppException {
    public AuthorizationException(String message) {
        super("AUTHORIZATION_ERROR", message);
    }
}

