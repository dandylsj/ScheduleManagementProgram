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

   // JPA 에의해서 외래키 제약조건이 자동으로
    @ManyToOne(fetch = FetchType.LAZY, optional = false) //JPA가 옵셔널 허용x //지연로딩
    @JoinColumn(name = "user_id", nullable = false) //nullable 은 DB에서 null의 허용여부
    private User user;  //userId 만 들고 와서 참조할 수도 있다.


    public Schedule(String title, String content,User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
