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
public class User extends UserBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //아이디 값
    @Column(length = 20)
    private String userName; //유저명
    @Column(length = 50)
    private String email; //이메일


    @OneToMany(mappedBy = "schedule_Table")
    private List<Schedule> schedules = new ArrayList<>();


}



