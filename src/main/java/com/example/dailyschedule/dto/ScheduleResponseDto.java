package com.example.dailyschedule.dto;

import com.example.dailyschedule.Entity.ScheduleEntity;
import lombok.Getter;
/**
 * 일정 응답 DTO
 */
@Getter
public class ScheduleResponseDto {
    private Long id;
    private String task;
    private String authorName;
    private String createDay;
    private String updatedDay;

    public ScheduleResponseDto(ScheduleEntity schedule){
        this.id = schedule.getId();
        this.task = schedule.getTask();
        this.authorName = schedule.getAuthorName();
        this.createDay = schedule.getCreatedDay().toString(); // YYYY-MM-DD 형식으로 받기 위한 문자열 변환.
        this.updatedDay = schedule.getUpdatedDay().toString();
    }
}
