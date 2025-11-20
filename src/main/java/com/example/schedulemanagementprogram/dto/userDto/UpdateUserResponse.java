package com.example.schedulemanagementprogram.dto.userDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateUserResponse {
    private final String userName; //유저 이름
    private final String email;//유저 이메일
    private final LocalDateTime modifyAt; //유저 수정일

    public UpdateUserResponse(String userName, String email, LocalDateTime modifyAt) {
        this.userName = userName;
        this.email = email;
        this.modifyAt = modifyAt;
    }

}
