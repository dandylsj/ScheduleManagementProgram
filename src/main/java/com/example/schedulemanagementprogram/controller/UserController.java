package com.example.schedulemanagementprogram.controller;


import com.example.schedulemanagementprogram.dto.scheduleDto.*;
import com.example.schedulemanagementprogram.dto.userDto.CreateUserRequest;
import com.example.schedulemanagementprogram.dto.userDto.CreateUserResponse;
import com.example.schedulemanagementprogram.dto.userDto.GetOneUserResponse;
import com.example.schedulemanagementprogram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //속성
    private final UserService userService;

    //

    //유저 생성
    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse>creat(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.save(request);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    //유저 조회
    @GetMapping("/findUser/{userName}")
    public ResponseEntity<GetOneUserResponse> getOne(@PathVariable String userName) {
        GetOneUserResponse result = userService.getOne(userName);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }



}
