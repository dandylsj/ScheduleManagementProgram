package com.example.schedulemanagementprogram.dto.userDto;


import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class CreateUserResponse {

    private Long id;
    private String userName;
    private String email;
    private LocalDateTime creatAt;
    private LocalDateTime modifyAt;

    public CreateUserResponse (Long id,String userName,String email,LocalDateTime creatAt,LocalDateTime modifyAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }

}
