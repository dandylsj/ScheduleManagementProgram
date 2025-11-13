package com.example.schedulemanagementprogram.dto.userDto;


import lombok.Getter;

@Getter
public class UpdateUserRequest {

    private String userName;
    private String email;



    public UpdateUserRequest(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
