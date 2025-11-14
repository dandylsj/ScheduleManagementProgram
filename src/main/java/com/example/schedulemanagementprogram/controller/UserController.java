package com.example.schedulemanagementprogram.controller;


import com.example.schedulemanagementprogram.dto.scheduleDto.*;
import com.example.schedulemanagementprogram.dto.userDto.*;
import com.example.schedulemanagementprogram.entity.User;
import com.example.schedulemanagementprogram.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

    //회원가입
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse user = userService.register(request);
        RegisterResponse response = new RegisterResponse(user.getId(), user.getUserName(), user.getEmail(), user.getCreatAt(), user.getModifyAt());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request, HttpSession session) {
        User user = userService.login(request);
        SessionUser sessionUser = new SessionUser(user.getId(), user.getEmail());
        session.setAttribute("loginUser", sessionUser);
        LoginResponse response = new LoginResponse(user.getId(), user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser, HttpSession session) {
        if (sessionUser == null) {
            return ResponseEntity.badRequest().build();
        }
        session.invalidate();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    //유저 생성
    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse>creat(@Valid @RequestBody CreateUserRequest request) {
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
    public ResponseEntity<UpdateUserResponse> update(@PathVariable Long id,@Valid @RequestBody UpdateUserRequest request) {
        UpdateUserResponse result = userService.update(id,request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //유저 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id,@Valid @RequestBody DeleteUserRequest request) {
        userService.delete(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
