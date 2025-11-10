package com.example.schedulemanagementprogram.service;

import com.example.schedulemanagementprogram.dto.*;
import com.example.schedulemanagementprogram.entity.Schedule;
import com.example.schedulemanagementprogram.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    //속성
    private final ScheduleRepository scheduleRepository;


    //생성자

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //기능

    //일정생성
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                saveSchedule.getId(),
                saveSchedule.getAuthor(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getCreatAt(),
                saveSchedule.getModifyAt()
        );
    }

    //일정조회
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(String author) {
        Schedule user = scheduleRepository.findByAuthor(author).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        return new GetOneScheduleResponse(
                user.getId(),
                user.getAuthor(),
                user.getTitle(),
                user.getContent(),
                user.getCreatAt().toString(),
                user.getModifyAt().toString()
        );
    }

    //다건 조회
    @Transactional(readOnly = true)
    public List<GetOneScheduleResponse> getAll() {
        List<Schedule> allScheduleList = scheduleRepository.findAllByOrderByCreatAtDesc();

        List<GetOneScheduleResponse> dtos = new ArrayList<>();
        for (Schedule schedule : allScheduleList) {
            dtos.add(new GetOneScheduleResponse(
                    schedule.getId(),
                    schedule.getAuthor(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getCreatAt().toString(),
                    schedule.getModifyAt().toString()
            ));
        }
        return dtos;
    }



    // 일정 수정
    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        schedule.update(
                request.getTitle(),
                request.getContent()
        );
        return new UpdateScheduleResponse(
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getModifyAt()
        );

    }
}
