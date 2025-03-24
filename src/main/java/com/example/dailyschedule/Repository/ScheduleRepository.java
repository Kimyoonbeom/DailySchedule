package com.example.dailyschedule.Repository;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.dto.ScheduleResponseDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ScheduleRepository {

    ScheduleEntity saveSchedule(ScheduleEntity schedule); // 저장

    List<ScheduleResponseDto> findAllSchedules(String updateDay, String authorName); // 모든 일정을 조회.

    ScheduleEntity findScheduleById(Long id); // ID로 일정 조회.

    void deleteSchedule(Long id); // ID로 일정 삭제.

    ScheduleEntity mapRowToSchedule(ResultSet resultSet, int i) throws SQLException; //
}
