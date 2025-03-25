package com.example.dailyschedule.Service;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.Repository.ScheduleRepository;
import com.example.dailyschedule.dto.ScheduleRequestDto;
import com.example.dailyschedule.dto.ScheduleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void createSchedule(ScheduleRequestDto request) {
        ScheduleEntity schedule = new ScheduleEntity(
                request.getTask(),
                request.getAuthorName(),
                request.getPassword()
        );
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
    public boolean updateSchedule(Long id, ScheduleRequestDto request) {
        ScheduleEntity existingSchedule = scheduleRepository.findScheduleById(id);
        if (existingSchedule != null && existingSchedule.getPassword().equals(request.getPassword())) {
            existingSchedule.update(request.getTask(), request.getAuthorName());
            scheduleRepository.saveSchedule(existingSchedule);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSchedule(Long id, String password) {
        int rowsDeleted = scheduleRepository.deleteSchedule(id, password);
        return rowsDeleted > 0;
    }
}
