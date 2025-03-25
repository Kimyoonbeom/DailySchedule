package com.example.dailyschedule.Repository;

import com.example.dailyschedule.Entity.ScheduleEntity;
import com.example.dailyschedule.dto.ScheduleResponseDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ScheduleRepository {

    ScheduleEntity saveSchedule(ScheduleEntity schedule); // 저장

    List<ScheduleResponseDto> findAllSchedules(String updateDay, String authorName); // 모든 일정을 조회.

    ScheduleEntity findScheduleById(Long id); // ID로 일정 조회.

    /*
        선택한 일정을 삭제할 수 있습니다.
        서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
         */
    int deleteSchedule(Long id, String password); // ID로 일정 삭제.

    ScheduleEntity mapRowToSchedule(ResultSet resultSet, int i) throws SQLException; //

    // 일정 수정 및 삭제 기능 추가.
    /*
    선택한 일정 내용 중 `할일`, `작성자명` 만 수정 가능
    서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
    `작성일` 은 변경할 수 없으며, `수정일` 은 수정 완료 시, 수정한 시점으로 변경합니다.
     */
    int updateSchedule(Long id, String task, String authorName, String password);
}
