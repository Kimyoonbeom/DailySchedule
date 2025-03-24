package com.example.dailyschedule.Controller;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.Service.ScheduleService;
import com.example.dailyschedule.dto.ScheduleRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody ScheduleRequestDto request){
        ScheduleEntity schedule = new ScheduleEntity(
                request.getTask(),
                request.getAuthorName(),
                request.getPassword()
        );
        scheduleService.createSchedule(schedule);
        return ResponseEntity.ok("일정이 생성되었습니다.");
    }
}
