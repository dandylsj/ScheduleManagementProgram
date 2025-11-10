package com.example.schedulemanagementprogram.controller;

import com.example.schedulemanagementprogram.dto.*;
import com.example.schedulemanagementprogram.entity.Schedule;
import com.example.schedulemanagementprogram.service.ScheduleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    //속성
    private final ScheduleService scheduleService;

    //기능

    //일정 생성 컨트롤러
    @PostMapping("/create")
    public ResponseEntity<CreateScheduleResponse>creat(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //일정 조회 컨트롤러
    @GetMapping("/{id}")
    public ResponseEntity<GetOneScheduleResponse> getOne(@PathVariable String author) {
        GetOneScheduleResponse result = scheduleService.getOne(author);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //다 건 조회 컨트롤러
    @GetMapping("/all")
    public ResponseEntity<List<GetOneScheduleResponse>> getAll() {
        List<GetOneScheduleResponse> result = scheduleService.getAll();
        return ResponseEntity.ok(result);
    }

    //일정수정 컨트롤러
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateScheduleResponse> update(@PathVariable Long id, @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse result = scheduleService.update(id,request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //일정 삭제 컨트롤러
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteRequest> delete(@PathVariable Long id,@RequestBody DeleteRequest request) {
        scheduleService.delete(id,request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
