package com.example.schedulemanagementprogram.dto.userDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetOneUserResponse {
    private final String userName; //유저 이름
    private final String email; //유저 이메일
    private final LocalDateTime creatAt; //유저 생성일
    private final LocalDateTime modifyAt; //유저 수정일

    public GetOneUserResponse(String userName, String email, LocalDateTime creatAt, LocalDateTime modifyAt) {
        this.userName = userName;
        this.email = email;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }
}
