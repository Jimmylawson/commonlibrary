package com.commonlibrary.commonlibrary.exceptions;



public class UserDuplicateException extends BusinessException {
    public UserDuplicateException(Long userId) {
        super("User already exists with id: " + userId, "DUPLICATE_USER");
    }
}
