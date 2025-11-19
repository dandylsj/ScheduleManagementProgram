package com.example.schedulemanagementprogram.controller;

import com.example.schedulemanagementprogram.dto.scheduleDto.*;
import com.example.schedulemanagementprogram.dto.userDto.SessionUser;
import com.example.schedulemanagementprogram.entity.Schedule;
import com.example.schedulemanagementprogram.repository.ScheduleRepository;
import com.example.schedulemanagementprogram.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.RejectedExecutionException;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    //속성
    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    //기능
    /**
     *일정 생성 컨트롤러
     * @param sessionUser
     * @param request
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<CreateScheduleResponse>creat(@SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser, @RequestBody CreateScheduleRequest request) {
        //1.일정 생성시 로그인을 했는지 확인
        if (sessionUser == null) {
            return ResponseEntity.badRequest().build();
        }
        //2. 확인 후 세션 아이디를 조회 하여 변수에 저장
        Long id = sessionUser.getId();
        //3.스케줄 서비스에서 저장한 일정을 세션 아이디와 ,body에서 받은 리퀘스트 값을을 결과에 저장
        CreateScheduleResponse result = scheduleService.save(id,request);
        //4.바디값과 함께 http 상태를 리턴한다.
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //일정 조회 컨트롤러
    @GetMapping("/{scheduleId}")
    public ResponseEntity<GetOneScheduleResponse> getOne(@PathVariable Long scheduleId) {
        //1.스케줄 서비스에서 조회한 스케줄을 변수에 넣는다.
        GetOneScheduleResponse result = scheduleService.getOne(scheduleId);
        //2.조회한 결과값을 리턴한다.
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //다 건 조회 컨트롤러
    @GetMapping("/all")
    public ResponseEntity<List<GetOneScheduleResponse>> getAll() {
        //1.스케줄 서비스에 있는 모든 일정을 리스트형식에 넣는다.
        List<GetOneScheduleResponse> result = scheduleService.getAll();
        return ResponseEntity.ok(result);
    }

    //일정수정 컨트롤러
    @PutMapping("/update/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> update(@SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequest request) {
        //1.로그인하지 않은 상태로 일정을 수정할경우 400에러 리턴
        if (sessionUser == null) {
            return ResponseEntity.badRequest().build();
        }
        //2.로그인 한 상태에서 수정할 경우 세션아이디와 스케줄 아이디, 바디값을 변수에 저장
    UpdateScheduleResponse result = scheduleService.update(sessionUser,scheduleId, request);
        //3.결과값을 스테이터스와 함께 리턴
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //일정 삭제 컨트롤러
    @DeleteMapping("/delete/{scheduleId}")
    public ResponseEntity<DeleteRequest> delete(@SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,@PathVariable Long scheduleId) {
        //1.URL 에서 입력한 일정 id 를 삭제 하여 리턴한다.
        if (sessionUser == null) {
            return ResponseEntity.badRequest().build();
        }
        //2.서비스 에서 작성한 유저와 로그인유저가 맞으면 삭제 완료
        scheduleService.delete(sessionUser,scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
