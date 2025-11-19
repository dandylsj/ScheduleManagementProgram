package com.example.schedulemanagementprogram.dto.scheduleDto;

import com.example.schedulemanagementprogram.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private User user;
    private final long scheduleId;
    private final String title;
    private final String content;
    private final LocalDateTime creatAt;
    private final LocalDateTime modifyAt;

    public CreateScheduleResponse(Long scheduleId, String title, String content,LocalDateTime creatAt, LocalDateTime modifyAt,User user) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
        this.user = user;
    }
}
