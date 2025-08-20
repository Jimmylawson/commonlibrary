package com.commonlibrary.commonlibrary.exceptions;

public class DuplicateResourceException extends BusinessException {
    public DuplicateResourceException(String resourceName) {
        super(resourceName + " already exists ", "DUPLICATE_RESOURCE");
    }
}
