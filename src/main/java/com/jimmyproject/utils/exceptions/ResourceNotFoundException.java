package com.jimmyproject.utils.exceptions;

public abstract class ResourceNotFoundException extends AppException {
    protected ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super("NOT_FOUND",
                String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
    }

}
