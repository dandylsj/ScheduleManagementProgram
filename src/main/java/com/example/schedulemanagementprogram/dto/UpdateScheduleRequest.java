package com.example.schedulemanagementprogram.dto;


import lombok.Getter;

@Getter
public class UpdateScheduleRequest {

    private Long id;
    private String title;
    private String content;
    private String password;

}
