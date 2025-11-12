package com.example.schedulemanagementprogram.dto.userDto;

import java.time.LocalDateTime;

public class GetOneUserResponse {
    private String userName;
    private String email;
    private LocalDateTime creatAt;
    private LocalDateTime modifyAt;

    public GetOneUserResponse(String userName, String email, LocalDateTime creatAt, LocalDateTime modifyAt) {
        this.userName = userName;
        this.email = email;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }
}
