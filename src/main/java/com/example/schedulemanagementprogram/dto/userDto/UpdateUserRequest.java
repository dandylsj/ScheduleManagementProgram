package com.example.schedulemanagementprogram.dto.userDto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    private String userName; //유저이름
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email; //유저 이메일
    @Size(min = 4,message = "비밀번호는 {min}자 이상이어야 합니다")
    private String password; //유저 패스워드




    public UpdateUserRequest(String userName, String email,String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
