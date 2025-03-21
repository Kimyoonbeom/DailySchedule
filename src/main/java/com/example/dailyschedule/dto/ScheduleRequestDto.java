package com.example.dailyschedule.dto;
import lombok.Getter;

/**
 * 일정 요청 DTO
 */

@Getter
public class ScheduleRequestDto {
    private String task;
    private String authorName;
    private String password;
}
