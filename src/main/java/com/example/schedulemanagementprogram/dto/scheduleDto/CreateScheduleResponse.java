package com.example.schedulemanagementprogram.dto.scheduleDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private final long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime creatAt;
    private final LocalDateTime modifyAt;

    public CreateScheduleResponse(Long id, String author, String title, String content, LocalDateTime creatAt, LocalDateTime modifyAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }
}
