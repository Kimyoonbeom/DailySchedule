package com.example.dailyschedule.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ScheduleEntity {
    private Long id;
    private String task;
    private String authorName;
    private String password;
    private LocalDate createdDay;
    private LocalDate updatedDay;

    public ScheduleEntity(String task, String authorName, String password) {
        this.task = task;
        this.authorName = authorName;
        this.password = password;
        this.createdDay = LocalDate.now();
        this.updatedDay = LocalDate.now();
    }

    public void update(String task, String authorName) {
        this.task = task;
        this.authorName = authorName;
        this.createdDay = LocalDate.now();
        this.updatedDay = LocalDate.now();
    }
}
