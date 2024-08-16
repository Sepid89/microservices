package com.sepidejd.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcetion extends RuntimeException{
    public ResourceNotFoundExcetion(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with given input data %s : %s",resourceName,fieldName,fieldValue));
    }
}
