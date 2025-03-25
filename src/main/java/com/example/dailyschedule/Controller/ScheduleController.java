package com.example.dailyschedule.Controller;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.Service.ScheduleService;
import com.example.dailyschedule.dto.ScheduleRequestDto;
import com.example.dailyschedule.dto.ScheduleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules(
            @RequestParam(required = false) String updatedDay,
            @RequestParam(required = false) String authorName){
        return ResponseEntity.ok(scheduleService.getAllSchedules(updatedDay, authorName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        ScheduleEntity schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(new ScheduleResponseDto(schedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long id,
                                                 @RequestBody
                                                 ScheduleRequestDto request,
                                                 @RequestParam String password){
        boolean isUpdated = scheduleService.updateSchedule(id, request.getTask(), request.getAuthorName(), password);
        return ResponseEntity.ok("일정이 수정되었습니다.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id,
                                                 @RequestParam String password){
        boolean isDeleted = scheduleService.deleteSchedule(id, password);
        return ResponseEntity.ok("일정이 삭제되었습니다.");
    }
}
