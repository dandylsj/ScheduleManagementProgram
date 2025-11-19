package com.example.schedulemanagementprogram.dto.scheduleDto;


import com.example.schedulemanagementprogram.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    private final String title;
    private final String content;
    private final LocalDateTime modifyAt;
    private final String email;

    public UpdateScheduleResponse(String title, String content, LocalDateTime modifyAt,String email) {
        this.title = title;
        this.content = content;
        this.modifyAt = modifyAt;
        this.email = email;
    }
}
