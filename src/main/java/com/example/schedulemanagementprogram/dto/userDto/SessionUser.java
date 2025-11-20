package com.example.schedulemanagementprogram.dto.userDto;

import com.example.schedulemanagementprogram.entity.User;
import lombok.Getter;

@Getter
public class SessionUser {

    private final Long id; //유저 아이디
    private final String email; //유저 이메일

    public SessionUser(Long id, String email) {
        this.id = id;
        this.email = email;
    }

}
