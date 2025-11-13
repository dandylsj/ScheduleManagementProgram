package com.example.schedulemanagementprogram.dto.userDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateUserResponse {
    private final String userName;
    private final String email;
    private final LocalDateTime modifyAt;

    public UpdateUserResponse(String userName, String email, LocalDateTime modifyAt) {
        this.userName = userName;
        this.email = email;
        this.modifyAt = modifyAt;
    }

}
