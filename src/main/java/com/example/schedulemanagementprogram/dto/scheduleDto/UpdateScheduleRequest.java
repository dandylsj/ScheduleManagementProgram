package com.example.schedulemanagementprogram.dto.scheduleDto;


import lombok.Getter;

@Getter
public class UpdateScheduleRequest {

    private Long id;
    private String title;
    private String content;

}
