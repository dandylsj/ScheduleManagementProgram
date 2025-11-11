package com.example.schedulemanagementprogram.dto.scheduleDto;

import lombok.Getter;

@Getter
public class GetOneScheduleResponse {
    private final Long id;
    private final String author;
    private final String title;
    private final String content;
    private final String creatAt;
    private final String modifyAt;

    public GetOneScheduleResponse(Long id, String author, String title, String content, String creatAt, String modifyAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }
}
