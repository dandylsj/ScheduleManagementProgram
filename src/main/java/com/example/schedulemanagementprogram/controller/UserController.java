package com.example.schedulemanagementprogram.controller;


import com.example.schedulemanagementprogram.dto.scheduleDto.*;
import com.example.schedulemanagementprogram.dto.userDto.*;
import com.example.schedulemanagementprogram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/findUser/{id}")
    public ResponseEntity<GetOneUserResponse> getOne(@PathVariable Long id) {
        GetOneUserResponse result = userService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //유저 수정
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UpdateUserResponse> update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        UpdateUserResponse result = userService.update(id,request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //유저 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
