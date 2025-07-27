package com.jimmyproject.utils.exceptions;

public class DuplicateUserException extends ResourceAlreadyExistsException {
    public DuplicateUserException(String fieldName, Object fieldValue) {
        super("User", fieldName, fieldValue);
    }
}
