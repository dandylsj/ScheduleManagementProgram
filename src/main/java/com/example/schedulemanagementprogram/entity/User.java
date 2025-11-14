package com.example.schedulemanagementprogram.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "user_table")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //아이디 값
    @Column(length = 20)
    private String userName; //유저명
    @Column(length = 50)
    private String email; //이메일
    @Column(length = 30)
    private String password; //비밀번호


    public User(String userName, String email,String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",message = "이메일 형식에 맞지 않습니다.") String email, @Size(min = 4,message = "비밀번호는 {min}자 이상이어야 합니다") String password) {
        super();
    }

    public void getUserName(String userName) {
        this.userName = userName;
    }

    //유저 수정
    public void update(String userName, String email, @Size(min = 4, message = "비밀번호는 {min}자 이상이어야 합니다") String password) {
        this.userName = userName;
        this.email = email;
    }
}



