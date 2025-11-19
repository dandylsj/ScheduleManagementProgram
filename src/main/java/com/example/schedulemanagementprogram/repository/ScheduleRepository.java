package com.example.schedulemanagementprogram.repository;

import com.example.schedulemanagementprogram.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    /**
     * 생성일 기준 내림차순으로 모든 일정 조회
     * @return
     */
    List<Schedule> findAllByOrderByCreatAtDesc();

    /**
     * 특정 사용자가 작성한 모든 일정을 조회
     * @param userId
     * @return
     */
    List<Schedule> findAllByUser_Id(Long userId);

}
