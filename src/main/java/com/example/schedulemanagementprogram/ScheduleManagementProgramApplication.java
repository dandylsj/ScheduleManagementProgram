package com.example.schedulemanagementprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleManagementProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleManagementProgramApplication.class, args);
    }

}
