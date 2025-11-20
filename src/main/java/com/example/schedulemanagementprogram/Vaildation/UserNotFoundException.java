package com.example.schedulemanagementprogram.Vaildation;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
