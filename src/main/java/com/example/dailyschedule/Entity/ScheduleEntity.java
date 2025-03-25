package com.example.dailyschedule.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ScheduleEntity {
    private Long id;                // id
    private String task;            // 할 일
    private String authorName;      // 작성자 이름.
    private String password;        // 비밀번호
    private LocalDate createDay;    // 작성 날짜
    private LocalDate updatedDay;   // 수정 날짜

    public ScheduleEntity(String task, String authorName, String password) {
        this.task = task;
        this.authorName = authorName;
        this.password = password;
        this.createDay = LocalDate.now();
        this.updatedDay = LocalDate.now();
    }

    public void update(String task, String authorName) {
        this.task = task;
        this.authorName = authorName;
        this.createDay = LocalDate.now();
        this.updatedDay = LocalDate.now();
    }
}
