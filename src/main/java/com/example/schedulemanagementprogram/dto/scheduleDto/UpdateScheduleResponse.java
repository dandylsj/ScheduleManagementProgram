package com.example.schedulemanagementprogram.dto.scheduleDto;


import com.example.schedulemanagementprogram.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    private final String title; //일정게시글 제목
    private final String content; //일정게시글 내용
    private final LocalDateTime modifyAt; //일정게시글 수정일
    private final String email; //유저의 이메일

    public UpdateScheduleResponse(String title, String content, LocalDateTime modifyAt,String email) {
        this.title = title;
        this.content = content;
        this.modifyAt = modifyAt;
        this.email = email;
    }
}
