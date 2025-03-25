package com.example.dailyschedule.dto;

import com.example.dailyschedule.Entity.ScheduleEntity;
import lombok.Getter;
/**
 * 일정 응답 DTO
 */
@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String task;
    private final String authorName;
    private final String createDay;
    private final String updatedDay;

    public ScheduleResponseDto(ScheduleEntity schedule){
        this.id = schedule.getId();
        this.task = schedule.getTask();
        this.authorName = schedule.getAuthorName();
        this.createDay = schedule.getCreateDay().toString(); // YYYY-MM-DD 형식으로 받기 위한 문자열 변환.
        this.updatedDay = schedule.getUpdatedDay().toString();
    }
}
