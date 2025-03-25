package com.example.dailyschedule.Service;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.dto.ScheduleRequestDto;
import com.example.dailyschedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    void createSchedule(ScheduleRequestDto request);
    List<ScheduleResponseDto> getAllSchedules(String updatedDay, String authorName);
    ScheduleEntity getScheduleById(Long id);
    boolean updateSchedule(Long id, ScheduleRequestDto request);
    boolean deleteSchedule(Long id, String password);
}

