package com.example.schedulemanagementprogram.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public void getUserName(String userName) {
        this.userName = userName;
    }

    public void update(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}



