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
        //1. 스케줄을 새로 생성한다.
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        //2. 생성한 스케줄을 데이터베이스에 저장한다.
        Schedule saveSchedule = scheduleRepository.save(schedule);
        //3. 저장한 스케줄을 응답한다.
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
        //1. 작성자 명에 맞는 스케줄을 조회한다.
        Schedule user = scheduleRepository.findByAuthor(author).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        //2. 조회한 스케줄을 포장해서 응답한다.
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
        //1. 스케줄을 레포지토리에서 내림차순으로 정렬 한 후 조회한다.
        List<Schedule> allScheduleList = scheduleRepository.findAllByOrderByCreatAtDesc();

        //2. 스케줄 조회 속성을 스케줄을 리스트에 담는다.
        List<GetOneScheduleResponse> dtos = new ArrayList<>();
        //3. 레포지토리에 있는 스케줄을 전부 스캔한다.
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
        //4. 스케줄 리스트를 응답한다.
        return dtos;
    }



    // 일정 수정
    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) {
        //1. 생성한 일정 아이디 값이 맞는 스케줄을 조회한다.
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        //2. 클라이언트가 보낸 바디값을 수정한다.
        schedule.update(
                request.getTitle(),
                request.getContent()
        );
        //3. 수정한 바디값과 수정날짜를 응답한다.
        return new UpdateScheduleResponse(
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getModifyAt()
        );

    }

    //일정 삭제
    @Transactional
    public void delete(Long id, DeleteRequest request) {
        // 1. 일정 삭제가 가능한지 조회 해보기
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("선택한 일정이 존재하지 않습니다.")
        );
        //2. 패스워드가 일치하는지 확인하기
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
        //3. 일정 삭제
        scheduleRepository.deleteById(id);
    }
}
