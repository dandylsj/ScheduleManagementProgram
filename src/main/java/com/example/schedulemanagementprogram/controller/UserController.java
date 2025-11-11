package com.example.schedulemanagementprogram.controller;


import com.example.schedulemanagementprogram.dto.scheduleDto.CreateScheduleRequest;
import com.example.schedulemanagementprogram.dto.scheduleDto.CreateScheduleResponse;
import com.example.schedulemanagementprogram.dto.userDto.CreateUserRequest;
import com.example.schedulemanagementprogram.dto.userDto.CreateUserResponse;
import com.example.schedulemanagementprogram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //속성
    private final UserService userService;

    //

    //
    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse>creat(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.save(request);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
