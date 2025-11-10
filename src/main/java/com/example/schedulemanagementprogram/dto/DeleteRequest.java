package com.example.schedulemanagementprogram.dto;

import lombok.Getter;

@Getter
public class DeleteRequest {

    //속성
    private String password;


    //생성자
    public DeleteRequest (String password) {
        this.password = password;
    }

}
