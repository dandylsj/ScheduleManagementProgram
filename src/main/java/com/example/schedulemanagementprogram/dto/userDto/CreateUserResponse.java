package com.example.schedulemanagementprogram.dto.userDto;


import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class CreateUserResponse {

    private String userName;
    private String email;
    private LocalDateTime userCreatAt;
    private LocalDateTime userModifyAt;

    public CreateUserResponse (String userName,String email,LocalDateTime userCreatAt,LocalDateTime userModifyAt) {
        this.userName = userName;
        this.email = email;
        this.userCreatAt = userCreatAt;
        this.userModifyAt = userModifyAt;
    }

}
