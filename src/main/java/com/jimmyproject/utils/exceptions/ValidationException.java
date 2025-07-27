package com.jimmyproject.utils.exceptions;

import java.util.Map;

// For validation failures
public class ValidationException extends AppException {
    private final Map<String, String> errors;

    public ValidationException(String message, Map<String, String> errors) {
        super("VALIDATION_ERROR", message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}