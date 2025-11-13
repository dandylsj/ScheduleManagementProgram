package com.example.schedulemanagementprogram.service;

import com.example.schedulemanagementprogram.dto.scheduleDto.GetOneScheduleResponse;
import com.example.schedulemanagementprogram.dto.userDto.*;
import com.example.schedulemanagementprogram.entity.Schedule;
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
                saveUser.getId(),
                saveUser.getUserName(),
                saveUser.getEmail(),
                saveUser.getCreatAt(),
                saveUser.getModifyAt()
        );
    }
    //유저 조회
    @Transactional(readOnly = true)
    public GetOneUserResponse getOne(Long id) {
       User user = userRepository.findById(id).orElseThrow(
               () -> new IllegalStateException("없는 유저입니다.")
       );
//       List<GetOneUserResponse> dtos = new ArrayList<>();

       return new GetOneUserResponse(  //박스를 만들어서 넘겨준다. //메서드의 결과가 리턴타입이 된다.
               user.getUserName(),
               user.getEmail(),
               user.getCreatAt(),
               user.getModifyAt()

       );
//       for (User u: userList) {
//           GetOneUserResponse dto = new GetOneUserResponse(  //박스를 만들어서 넘겨준다. //메서드의 결과가 리턴타입이 된다.
//                   u.getUserName(),
//                   u.getEmail(),
//                   u.getCreatAt(),
//                   u.getModifyAt()
//           );
//           dtos.add(dto);
//       }
//       return dtos;
    }

    //유저 수정
    @Transactional
    public UpdateUserResponse update(Long id,UpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        user.update(
                request.getUserName(),
                request.getEmail()
        );
        return new UpdateUserResponse(
                user.getUserName(),
                user.getEmail(),
                user.getModifyAt()
        );
    }

    //유저삭제
    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow( //레포지토리의 아이디를 찾아보고 아이디 값이 있으면 넘어가고
                () -> new IllegalArgumentException("선택한 일정이 존재하지 않습니다.") //없으면 orElseThrow - 예외를 발생시킨다.
        );
        userRepository.deleteById(id); //삭제
    }

}
