package com.example.dailyschedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody Schedule daily_schedule){
        scheduleService.createSchedule(daily_schedule);
        return ResponseEntity.ok("일정이 생성되었습니다.");
    }
}
