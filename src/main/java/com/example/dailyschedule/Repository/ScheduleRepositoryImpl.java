package com.example.dailyschedule.Repository;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.dto.ScheduleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class ScheduleRepositoryImpl implements ScheduleRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ScheduleEntity saveSchedule(ScheduleEntity schedule){
        String sql = "INSERT INTO schedules (task, author_name, password, create_day, updated_day) " +
                "VALUES (task = ?, author_name = ?, password = ?, NOW(), NOW())";
        jdbcTemplate.update(sql, schedule.getTask(), schedule.getAuthorName(), schedule.getPassword());

        return schedule;
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules(String updatedDay, String authorName) {
        String sql = "SELECT * FROM schedules WHERE (DATE(updated_day) = ? OR ? IS NULL) AND (author_name = ? OR ? IS NULL) ORDER BY updated_day DESC";
        List<ScheduleEntity> schedules = jdbcTemplate.query(sql, this::mapRowToSchedule, updatedDay, updatedDay, authorName, authorName);

        List<ScheduleResponseDto> responseDtos = new ArrayList<>();
        for (ScheduleEntity schedule : schedules) {
            responseDtos.add(new ScheduleResponseDto(schedule)); // Entity → DTO 변환
        }
        return responseDtos;
    }
    @Override
    public ScheduleEntity findScheduleById(Long id) {
        String sql = "SELECT * FROM schedules WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToSchedule, id);
    }
}
