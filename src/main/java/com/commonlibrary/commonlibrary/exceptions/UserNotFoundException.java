package com.commonlibrary.commonlibrary.exceptions;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(Long userId){
        super("User not found with id: "+ userId, "USER_NOT_FOUND");
    }
}
