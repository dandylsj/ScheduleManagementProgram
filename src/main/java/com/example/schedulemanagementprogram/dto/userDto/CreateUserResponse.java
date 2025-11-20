package com.example.schedulemanagementprogram.dto.userDto;


import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class CreateUserResponse {

    private Long id; //유저 아이디
    private String userName; //유저 이름
    private String email; //유저 이메일
    private LocalDateTime creatAt; //유저 생성일
    private LocalDateTime modifyAt; //유저 수정일

    public CreateUserResponse (Long id,String userName,String email,LocalDateTime creatAt,LocalDateTime modifyAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.creatAt = creatAt;
        this.modifyAt = modifyAt;
    }

}
