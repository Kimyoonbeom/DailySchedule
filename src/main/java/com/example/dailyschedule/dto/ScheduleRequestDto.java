package com.example.dailyschedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 일정 요청 DTO
 */

@Getter
@Setter
@NoArgsConstructor
public class ScheduleRequestDto {

    private String task;

    private String authorName;

    private String password;

}
