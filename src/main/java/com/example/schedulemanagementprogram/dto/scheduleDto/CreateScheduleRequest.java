package com.example.schedulemanagementprogram.dto.scheduleDto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    private String title;
    private String content;
    private String user;
}
