package com.example.schedulemanagementprogram.repository;

import com.example.schedulemanagementprogram.entity.Schedule;
import com.example.schedulemanagementprogram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);
}

