package com.example.schedulemanagementprogram.controller;

import com.example.schedulemanagementprogram.dto.CreateScheduleRequest;
import com.example.schedulemanagementprogram.dto.CreateScheduleResponse;
import com.example.schedulemanagementprogram.dto.GetOneScheduleResponse;
import com.example.schedulemanagementprogram.entity.Schedule;
import com.example.schedulemanagementprogram.service.ScheduleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ScheduledExecutorService;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    //속성
    private final ScheduleService scheduleService;

    //기능
    @PostMapping("/create")
    public ResponseEntity<CreateScheduleResponse>creat(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{author}")
    public ResponseEntity<GetOneScheduleResponse> getOne(@PathVariable String author) {
        GetOneScheduleResponse result = scheduleService.getOne(author);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
