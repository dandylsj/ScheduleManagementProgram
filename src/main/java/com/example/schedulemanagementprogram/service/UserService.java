package com.example.schedulemanagementprogram.service;

import com.example.schedulemanagementprogram.dto.userDto.*;
import com.example.schedulemanagementprogram.entity.User;
import com.example.schedulemanagementprogram.repository.UserRepository;
import jakarta.validation.Valid;
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
                request.getEmail(),
                request.getPassword()
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
       return new GetOneUserResponse(  //박스를 만들어서 넘겨준다. //메서드의 결과가 리턴타입이 된다.
               user.getUserName(),
               user.getEmail(),
               user.getCreatAt(),
               user.getModifyAt()

       );
    }

    //유저 수정
    @Transactional
    public UpdateUserResponse update(Long id,UpdateUserRequest request) {
        //1.유저 레포지토리에 아이디를 조회하여 입력한 아이디 값이 없으면 에러발생
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        //2.있으면 입력한 유저이름과 이메일 비밀번호를 user에 저장
        user.update(
                request.getUserName(),
                request.getEmail(),
                request.getPassword()
        );
        //3. 수정한 속성들을 리턴한다.
        return new UpdateUserResponse(
                user.getUserName(),
                user.getEmail(),
                user.getModifyAt()
        );
    }

    //유저삭제
    @Transactional
    public void delete(Long id, DeleteUserRequest request) {
        // 1. 삭제할 유저가 DB에 존재하는지 확인
        User user = userRepository.findById(id).orElseThrow( //레포지토리의 아이디를 찾아보고 아이디 값이 있으면 넘어가고
                () -> new IllegalArgumentException("선택한 일정이 존재하지 않습니다.") //없으면 orElseThrow - 예외를 발생시킨다.
        );
        // 2. 비밀번호 일치 여부 확인
        if (!user.getPassword().equals(request.getPassword())) { //리퀘스트 받은 바디의 비밀번호 값이 , 엔티티의 비밀번호 값과 일치하는지 확인한다.
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다."); //일치하지 않으면 예외를 발생시킨다.
        }
        // 3. 유저 삭제
        userRepository.deleteById(id); //삭제
    }

    //회원가입
    public RegisterResponse register(@Valid RegisterRequest request) {
        //1. 입력한 유저의 속성을 가져와 변수에 저장
        User user = new User(
                request.getUserName(),
                request.getEmail(),
                request.getPassword()
        );

        //2.저장한 값을 유저 자료형 변수에 저장
        User saveUser = userRepository.save(user);

        //3. 저장한 유저를 응답한다.
        return new RegisterResponse(
                saveUser.getId(),
                saveUser.getUserName(),
                saveUser.getEmail(),
                saveUser.getCreatAt(),
                saveUser.getModifyAt()
        );

    }

    //로그인
    @Transactional(readOnly = true)
    public User login(LoginRequest request) {
        //1.유저 레포지토리에서 이메일을 조회 , 리퀘스트에서 입력한 이메일과 같지 않으면 에러 발생
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다."));
        //2. 입력한 비밀번화와 회원가입했던 비밀번호를 비교하여 같지 않으면 에러발생
        if (!request.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }
        //3.아이디와 비밀번호가 같으면 리턴하여 로그인
        return user;
    }
}
