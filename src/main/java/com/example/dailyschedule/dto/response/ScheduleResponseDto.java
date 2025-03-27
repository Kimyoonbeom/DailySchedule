package com.example.dailyschedule.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 일정 응답 DTO
 */
@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String task;
    private final String authorName;
    private final String createdAt;
    private final String updatedAt;

    public ScheduleResponseDto(Long id, String task, String authorName, LocalDateTime createDay, LocalDateTime updatedDay){
        this.id = id;
        this.task = task;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
