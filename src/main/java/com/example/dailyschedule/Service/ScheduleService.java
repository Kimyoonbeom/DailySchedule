package com.example.dailyschedule.Service;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.Repository.ScheduleRepository;
import com.example.dailyschedule.dto.ScheduleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    // 일정 생성.
    public void createSchedule(ScheduleEntity schedule){
        scheduleRepository.saveSchedule(schedule);
    }
    // 일정 조회.
    public List<ScheduleResponseDto> getAllSchedules(String updateDay, String authorName){
        return scheduleRepository.findAllSchedules(updateDay, authorName);
    }
    // ID로 일정 받기.
    public ScheduleEntity getSheduleByID(Long id){
        return scheduleRepository.findScheduleById(id);
    }
    // 일정 삭제.
    public void deleteSchedule(Long id){
        scheduleRepository.deleteSchedule(id);
    }
}
