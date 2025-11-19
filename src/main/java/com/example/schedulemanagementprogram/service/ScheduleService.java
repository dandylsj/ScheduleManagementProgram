package com.example.schedulemanagementprogram.service;

import com.example.schedulemanagementprogram.dto.scheduleDto.*;
import com.example.schedulemanagementprogram.dto.userDto.SessionUser;
import com.example.schedulemanagementprogram.entity.Schedule;
import com.example.schedulemanagementprogram.entity.User;
import com.example.schedulemanagementprogram.repository.ScheduleRepository;
import com.example.schedulemanagementprogram.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    //속성
    private final ScheduleRepository scheduleRepository; //스케줄 레포지토리
    private final UserRepository userRepository;



    //생성자

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    //기능

    //일정생성
    @Transactional
    public CreateScheduleResponse save(Long id,CreateScheduleRequest request) {
        //1.유저를 조회한다.
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다."));

        //2.조회한 유저를 스케줄을 새로 생성한다.
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                user
        );

        //3. 생성한 스케줄을 데이터베이스에 저장한다.
        Schedule saveSchedule = scheduleRepository.save(schedule);
        //4. 저장한 스케줄을 응답한다.
        return new CreateScheduleResponse(
                saveSchedule.getScheduleId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getCreatAt(),
                saveSchedule.getModifyAt(),
                user
        );
    }

    //일정조회
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(Long scheduleId) {
        //1. 스케줄 아이디로 검색을 한다.
        Schedule findScheduleId = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        //2. 조회한 스케줄을 포장해서 응답한다.
        return new GetOneScheduleResponse(
                findScheduleId.getScheduleId(),
                findScheduleId.getTitle(),
                findScheduleId.getContent(),
                findScheduleId.getCreatAt().toString(),
                findScheduleId.getModifyAt().toString(),
                findScheduleId.getUser().getEmail()
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
                    schedule.getScheduleId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getCreatAt().toString(),
                    schedule.getModifyAt().toString(),
                    schedule.getUser().getEmail()
            ));
        }
        //4. 스케줄 리스트를 응답한다.
        return dtos;
    }



    // 일정 수정
    @Transactional
    public UpdateScheduleResponse update(SessionUser sessionUser, Long scheduleId, UpdateScheduleRequest request) {
        //1.스케줄 조회를 먼저한다.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("없는 게시글 입니다.")
        );
        //2.스케줄의 유저 아이디와 세션의 유저 아이디와 비교한다.
        if(!sessionUser.getId().equals(schedule.getUser().getId())) {
            throw new IllegalArgumentException("작성한 유저가 아닙니다.");
        }
        //3. 클라이언트가 보낸 바디값을 수정한다.
        schedule.update(
                request.getTitle(),
                request.getContent()
        );
        //4. 수정한 바디값과 수정날짜를 응답한다.
        return new UpdateScheduleResponse(
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getModifyAt(),
                schedule.getUser().getEmail()
        );

    }

    //일정 삭제
    @Transactional
    public void delete(SessionUser sessionUser, Long scheduleId) {
        // 1. 일정 삭제가 가능한지 조회 해보기
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("선택한 일정이 존재하지 않습니다.")
        );
        //2. 스케줄을 작성한 유저와 세션 유저가 맞는지 확인한다. 아니면 에러 발생
        if(!sessionUser.getId().equals(schedule.getUser().getId())) {
            throw new IllegalArgumentException("작성한 유저가 아닙니다.");
        }
        //3. 맞으면 일정 삭제
        scheduleRepository.deleteById(scheduleId);
    }
}
