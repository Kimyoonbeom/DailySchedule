package com.example.dailyschedule.Controller;

import com.example.dailyschedule.dto.ScheduleRequestDto;
import com.example.dailyschedule.dto.ScheduleResponseDto;
import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody ScheduleRequestDto request) {
        ScheduleEntity schedule = new ScheduleEntity(
                request.getTask(),
                request.getAuthorName(),
                request.getPassword()
        );
        scheduleService.createSchedule(schedule);
        return ResponseEntity.ok("일정이 성공적으로 생성되었습니다.");
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules(
            @RequestParam(required = false) String updatedDay,
            @RequestParam(required = false) String authorName) {
        return ResponseEntity.ok(scheduleService.getAllSchedules(updatedDay, authorName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        ScheduleEntity schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(new ScheduleResponseDto(schedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long id,
                                                 @RequestBody ScheduleRequestDto request,
                                                 @RequestParam String password) {
        boolean isUpdated = scheduleService.updateSchedule(id, request.getTask(), request.getAuthorName(), password);
        if (isUpdated) {
            return ResponseEntity.ok("일정이 성공적으로 수정되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 잘못되었습니다.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id, @RequestParam String password) {
        boolean isDeleted = scheduleService.deleteSchedule(id, password);
        if (isDeleted) {
            return ResponseEntity.ok("일정이 성공적으로 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 잘못되었습니다.");
        }
    }
}
