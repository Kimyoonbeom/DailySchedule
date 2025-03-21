package com.example.dailyschedule.Repository;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleRepository {

    ScheduleEntity saveSchedule(ScheduleEntity schedule); // 저장

    List<ScheduleResponseDto> findAllSchedules(); // 모든 일정을 조회.

    ScheduleEntity findScheduleById(Long id); // ID로 일정 조회.

    void deleteschedule(Long id); // ID로 일정 삭제.
}
