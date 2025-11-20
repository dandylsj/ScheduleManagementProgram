package com.example.schedulemanagementprogram.dto.userDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginResponse {

    private final Long id; //유저 아이디 (FK)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",message = "이메일 형식에 맞지 않습니다.")
    private final String email; //유저 이메일

    public LoginResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
