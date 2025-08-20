package com.commonlibrary.commonlibrary.exceptions;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String resourceName, Object value){
        super(resourceName + " not found with id: " + value, "RESOURCE_NOT_FOUND");
    }
}
