package com.example.dailyschedule.Entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleEntity {
    private Long id;
    private String task;
    private String authorName;
    private String password;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;

    public ScheduleEntity(String task, String authorName, String password) {
        this.task = task;
        this.authorName = authorName;
        this.password = password;
        this.createdDay = LocalDateTime.now();
        this.updatedDay = LocalDateTime.now();
    }

    public void update(String task, String authorName) {
        this.task = task;
        this.authorName = authorName;
        this.createdDay = LocalDateTime.now();
        this.updatedDay = LocalDateTime.now();
    }
}
