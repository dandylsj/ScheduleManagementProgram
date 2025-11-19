package com.example.schedulemanagementprogram.dto.scheduleDto;

import com.example.schedulemanagementprogram.entity.User;
import lombok.Getter;

@Getter
public class GetOneScheduleResponse {

    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String creatAt;
    private final String modifyAt;
    private  final String email;

    public GetOneScheduleResponse(Long scheduleId, String title, String content, String creatAt, String modifyAt,String email) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
        this.email = email;
    }
}
