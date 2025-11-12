package com.example.schedulemanagementprogram.service;

import com.example.schedulemanagementprogram.dto.scheduleDto.GetOneScheduleResponse;
import com.example.schedulemanagementprogram.dto.userDto.CreateUserRequest;
import com.example.schedulemanagementprogram.dto.userDto.CreateUserResponse;
import com.example.schedulemanagementprogram.dto.userDto.GetOneUserResponse;
import com.example.schedulemanagementprogram.entity.User;
import com.example.schedulemanagementprogram.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    //속성
    private UserRepository userRepository;

    //생성자
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //기능

    //유저생성
    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        //1. 유저를 새로 생성한다.
        User user = new User(
                request.getUserName(),
                request.getEmail()
        );

        //2. 유저를 데이터베이스에 저장한다.
        User saveUser = userRepository.save(user);

        //3. 저장한 유저를 응답한다.
        return new CreateUserResponse(
                saveUser.getUserName(),
                saveUser.getEmail(),
                saveUser.getCreatAt(),
                saveUser.getModifyAt()
        );
    }
    //유저 조회
    @Transactional(readOnly = true)
    public GetOneUserResponse getOne(String userName) {
        User user = userRepository.findByUserName(userName).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        return new GetOneUserResponse(  //박스를 만들어서 넘겨준다. //메서드의 결과가 리턴타입이 된다.
                user.getUserName(),
                user.getEmail(),
                user.getCreatAt(),
                user.getModifyAt()
        );
    }


}
