package com.example.dailyschedule.Service.impl;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.Repository.ScheduleRepository;
import com.example.dailyschedule.Service.ScheduleService;
import com.example.dailyschedule.dto.ScheduleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void createSchedule(ScheduleEntity schedule) {
        scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> getAllSchedules(String updatedDay, String authorName) {
        return scheduleRepository.findAllSchedules(updatedDay, authorName);
    }

    @Override
    public ScheduleEntity getScheduleById(Long id) {
        return scheduleRepository.findScheduleById(id);
    }

    @Override
    public boolean updateSchedule(Long id, String task, String authorName, String password) {
        int rowsUpdated = scheduleRepository.updateSchedule(id, task, authorName, password);
        return rowsUpdated > 0;
    }

    @Override
    public boolean deleteSchedule(Long id, String password) {
        int rowsDeleted = scheduleRepository.deleteSchedule(id, password);
        return rowsDeleted > 0;
    }
}
