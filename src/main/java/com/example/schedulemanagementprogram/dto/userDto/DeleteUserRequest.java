package com.example.schedulemanagementprogram.dto.userDto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class DeleteUserRequest {

    private Long id;
    @Size(min = 4 , message = "비밀번호는 {min}자 이상이어야 합니다")
    private String password;
}
