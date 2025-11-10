package com.example.schedulemanagementprogram.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime creatAt;
    private LocalDateTime modifyAt;

    public CreateScheduleResponse(Long id, String author, String title, String content, LocalDateTime creatAt, LocalDateTime modifyAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }
}
