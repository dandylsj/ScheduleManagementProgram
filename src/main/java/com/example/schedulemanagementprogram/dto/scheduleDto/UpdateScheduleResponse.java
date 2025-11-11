package com.example.schedulemanagementprogram.dto.scheduleDto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    private final String title;
    private final String content;
    private final LocalDateTime modifyAt;

    public UpdateScheduleResponse(String title, String content, LocalDateTime modifyAt) {
        this.title = title;
        this.content = content;
        this.modifyAt = modifyAt;
    }
}
