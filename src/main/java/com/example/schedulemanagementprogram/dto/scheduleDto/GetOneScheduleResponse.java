package com.example.schedulemanagementprogram.dto.scheduleDto;

import com.example.schedulemanagementprogram.entity.User;
import lombok.Getter;

@Getter
public class GetOneScheduleResponse {

    private final Long scheduleId; //일정게시글 아이디
    private final String title; //일정게시글 제목
    private final String content; //일정게시글 내용
    private final String creatAt; //일정게시글 생성일
    private final String modifyAt; //일정게시글 수정일
    private  final String email; //유저의 이메일

    public GetOneScheduleResponse(Long scheduleId, String title, String content, String creatAt, String modifyAt,String email) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
        this.email = email;
    }
}
