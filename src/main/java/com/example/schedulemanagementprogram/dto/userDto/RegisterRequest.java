package com.example.schedulemanagementprogram.dto.userDto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegisterRequest {

    @Pattern(regexp = "^[가-힣]{2,10}$",
            message = "이름은 한글 2~10자로 입력하세요")
    private String userName;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",message = "이메일 형식에 맞지 않습니다.")
    private String email;
    @Size(min = 4,message = "비밀번호는 {min}자 이상이어야 합니다")
    private String password;

    public RegisterRequest(String userName,String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
