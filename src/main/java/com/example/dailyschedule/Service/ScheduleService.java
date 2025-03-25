package com.example.dailyschedule.Service;

import com.example.dailyschedule.dto.ScheduleResponseDto;
import com.example.dailyschedule.Entity.ScheduleEntity;

import java.util.List;

public interface ScheduleService {

    void createSchedule(ScheduleEntity schedule);
    List<ScheduleResponseDto> getAllSchedules(String updatedDay, String authorName);
    ScheduleEntity getScheduleById(Long id);
    boolean updateSchedule(Long id, String task, String authorName, String password);
    boolean deleteSchedule(Long id, String password);
}
