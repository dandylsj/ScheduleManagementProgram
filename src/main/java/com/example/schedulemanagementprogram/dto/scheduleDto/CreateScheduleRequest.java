package com.example.schedulemanagementprogram.dto.scheduleDto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    private String title; //일정게시글 제목
    private String content; //일정 내용

}