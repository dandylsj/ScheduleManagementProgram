package com.example.schedulemanagementprogram.repository;

import com.example.schedulemanagementprogram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
}
