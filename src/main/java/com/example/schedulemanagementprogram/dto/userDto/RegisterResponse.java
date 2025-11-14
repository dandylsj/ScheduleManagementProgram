package com.example.schedulemanagementprogram.dto.userDto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class RegisterResponse {
    private final Long id;
    private final String userName;
    private final String email;
    private final LocalDateTime creatAt;
    private final LocalDateTime modifyAt;

    public RegisterResponse(Long id,String userName,String email,LocalDateTime creatAt,LocalDateTime modifyAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }

}
