package com.example.schedulemanagementprogram.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    private String title;
    private String content;
    private LocalDateTime modifyAt;

    public UpdateScheduleResponse(String title, String content, LocalDateTime modifyAt) {
        this.title = title;
        this.content = content;
        this.modifyAt = modifyAt;
    }
}
