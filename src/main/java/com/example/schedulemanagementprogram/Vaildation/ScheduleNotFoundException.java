package com.example.schedulemanagementprogram.Vaildation;

import org.springframework.http.HttpStatus;

public class ScheduleNotFoundException extends ServiceException {
        public ScheduleNotFoundException(String message) {
            super(HttpStatus.BAD_REQUEST,message);
        }
    }
