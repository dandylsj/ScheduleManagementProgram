package com.example.schedulemanagementprogram.repository;

import com.example.schedulemanagementprogram.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
    
    Optional<Schedule> findByAuthor(String author); /* 단건조회시 사용하는 기능 */

    List<Schedule> findAllByOrderByCreatAtDesc(); /* 다건조회시 내림차순 정렬 기능 */

}
