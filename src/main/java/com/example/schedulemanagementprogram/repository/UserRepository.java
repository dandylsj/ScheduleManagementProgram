package com.example.schedulemanagementprogram.repository;

import com.example.schedulemanagementprogram.dto.userDto.SessionUser;
import com.example.schedulemanagementprogram.entity.Schedule;
import com.example.schedulemanagementprogram.entity.User;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long> {


    //이메일 중복 체크용으로 사용
    Optional<User> findByEmail(String email);


}

