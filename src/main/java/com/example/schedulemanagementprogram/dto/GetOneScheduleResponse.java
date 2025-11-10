package com.example.schedulemanagementprogram.dto;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class GetOneScheduleResponse {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String creatAt;
    private String modifyAt;

    public GetOneScheduleResponse(Long id, String author, String title, String content, String creatAt, String modifyAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }
}
