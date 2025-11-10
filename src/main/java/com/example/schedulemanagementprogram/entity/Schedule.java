package com.example.schedulemanagementprogram.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@Entity
@Table(name = "schedule_Table")
@NoArgsConstructor (access =AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //아이디 값
    @Column(length = 100) //타이틀의 길이
    private String title; //제목
    @Column(length = 1000) //내용의 길이
    private String content;  //내용
    @Column(length = 50,nullable = false)
    private String author;  //사용자 이름
    @Column(length = 50,nullable = false)
    private String password;  //비밀번호

    public Schedule(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }


}
