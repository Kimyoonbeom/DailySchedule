# 🤔일정 관리 앱 만들기

## API 명세서
- Postman(실패)
  https://documenter.getpostman.com/view/43244231/2sAYkKJxt3
- Notion(원했던거)
  https://www.notion.so/API-1c0062621e14803e8339f6b7ead7db0d?pvs=4


모든 일정 조회
- URL: /api/schedules

- Method: GET

- Query Parameters:

  - `updatedDay` (선택): 특정 날짜에 수정된 일정만 조회

  - `authorName` (선택): 특정 작성자의 일정만 조회

- Response: 일정 목록 반환

특정 일정 조회
- URL: /api/schedules/{id}

- Method: GET

- Response: 해당 ID의 일정 정보 반환

일정 수정
- URL: `/api/schedules/{id}`

- Method: PUT

- Response: 성공 시 "일정이 성공적으로 수정되었습니다." 메시지 반환

일정 삭제
- URL: `/api/schedules/{id}`

- Method: DELETE

- Query Parameters:

  - `password`: 일정 삭제를 위한 비밀번호

- Response: 성공 시 "일정이 성공적으로 삭제되었습니다." 메시지 반환

---
## ERD
![](https://velog.velcdn.com/images/kimybeom/post/33aed1c9-ab64-486c-8427-f3e8e3f6de1f/image.png)
---

## 클래스 구조 설명.

**▶️컨트롤러 (Controller)**
- `ScheduleController` 클래스가 RESTful API 엔드포인트를 정의.

- @RestController와 @RequestMapping 어노테이션을 사용하여 "/api/schedules" 경로의 요청을 처리.

- HTTP 메서드(GET, POST, PUT, DELETE)에 따라 다른 메서드가 호출.

**▶️서비스 (Service)**
- `ScheduleService` 인터페이스와 `ScheduleServiceImpl` 클래스가 비즈니스 로직을 담당.

- 컨트롤러와 리포지토리 사이의 중간 계층 역할.

- 데이터 검증, 예외 처리 등의 로직을 포함다.

**▶️리포지토리 (Repository)**
- `ScheduleRepository` 인터페이스와 그 구현체가 데이터베이스 작업을 처리.

- JDBC Template을 사용하여 SQL 쿼리를 실행.

**▶️엔티티 (Entity)**
- `ScheduleEntity` 클래스가 데이터베이스 테이블과 매핑되는 객체를 정의.

- 일정의 속성(id, task, authorName, password, createDay, updatedDay)을 포함.

**▶️DTO (Data Transfer Object)**
- `ScheduleRequestDto`: 클라이언트로부터 받는 데이터를 담는 객체.

- `ScheduleResponseDto`: 클라이언트에게 반환하는 데이터를 담는 객체.
