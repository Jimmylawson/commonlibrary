package com.jimmyproject.utils.exceptions;

// For duplicate/resource already exists scenarios
public abstract class ResourceAlreadyExistsException extends AppException {
    protected ResourceAlreadyExistsException(String resourceName, String fieldName, Object fieldValue) {
        super("RESOURCE_EXISTS",
                String.format("%s already exists with %s: %s", resourceName, fieldName, fieldValue));
    }
}