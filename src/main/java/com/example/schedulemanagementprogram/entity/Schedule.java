package com.example.schedulemanagementprogram.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedule_Table")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_table")
    private User user;


    public Schedule(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
