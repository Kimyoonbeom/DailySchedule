package com.example.dailyschedule.dto;

import java.time.LocalDateTime;

public class ScheduleDTO {
    private Long id;
    private String task;
    private String authorName;
    private LocalDateTime created_day;
    private LocalDateTime updated_day;

    //getter
    public Long getId(){
        return id;
    }

    public String getTask(){
        return task;
    }

    public String getAuthorName(){
        return authorName;
    }

    public LocalDateTime getCreated_day(){
        return created_day;
    }

    public LocalDateTime getUpdated_day() {
        return updated_day;
    }

    // setter
    public Long setId(){
        return id;
    }

    public String setTask(){
        return task;
    }

    public String setAuthorName(){
        return authorName;
    }

    public LocalDateTime setCreated_day(){
        return created_day;
    }

    public LocalDateTime setUpdated_day() {
        return updated_day;
    }
}

