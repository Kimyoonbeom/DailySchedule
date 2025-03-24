package com.example.dailyschedule.Service;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public void createSchedule(ScheduleEntity schedule){
        scheduleRepository.saveSchedule(schedule);
    }

    public
}
