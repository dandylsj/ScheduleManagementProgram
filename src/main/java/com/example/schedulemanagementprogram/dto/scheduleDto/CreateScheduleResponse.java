package com.example.schedulemanagementprogram.dto.scheduleDto;

import com.example.schedulemanagementprogram.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private User user; //유저의 정보
    private final long scheduleId; //일정게시글 아이디
    private final String title; //일정게시글 제목
    private final String content; //일정게시글 내용
    private final LocalDateTime creatAt; //일정게시글 생성일
    private final LocalDateTime modifyAt; //일정게시글 수정일

    public CreateScheduleResponse(Long scheduleId, String title, String content,LocalDateTime creatAt, LocalDateTime modifyAt,User user) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
        this.user = user;
    }
}
