# Reservation App
회의실 예약 정보 입력

## Environment
1. Java version: 1.8.0+
2. Default Encoding: UTF-8
3. Default File System: Linux

# Build
- gradle wrapper 사용 `./gradlew {task}` 

## Testing
./gradlew clean test

## Packaging
./gradlew bootRepackage

### jar, war 만 원할 경우
```bash
./gradlew bootRepackage
```

#### 인터넷이 필요 없는 로컬 개발환경
- local, h2 메모리 DB 사용


#system
API 테스트 : http://localhost:8089/swagger-ui.html
DB 조회 : http://localhost:8089/console

#문제해결 전략 및 프로젝트 빌드, 실행 방법 명
```
 기능
- 예약 시간은 정시, 30분을 기준으로 시작하여 30분 단위로 예약 가능
  - 예) 13:00 ~ 16:30 예약, 17:00 ~ 17:30 예약
  - 13:05 ~ 14:10 과 같이 정시, 30분 시작이 아닌 경우 예약 불가능
  
=> Controller에서 유효성 체크 ( 시작/종료일 차이 30분 and 30 나머지 0)
  
- 1회성 예약과 주 단위 반복 예약 설정 가능
  - 반복 예약 시 선택한 날짜의 요일 마다 반복, 반복 횟수 지정 필수(반복 횟수는 예약에 포함됨)
  - 예) 2018년 5월 31일(목) 14:00 ~ 15:00 반복 예약 시 지정한 종료일까지 매주 목요일에 반복 예약

=> 선택 한 날짜 + week = 반복횟수 만큼 date 입력.
  
- 동일한 회의실에 중첩된 일시로 예약 불가
  - 종료 시각과 시작 시각이 겹치는 경우는 중첩으로 판단하지 않음
  - 예) 동일 날짜, 회의실에 대해 14:00 ~ 15:00, 15:00 ~ 16:00 두 건은 예약가능
  
=> 날짜비교 처리.

- 다수의 사용자가 동시에 동일 날짜, 회의실에 예약할 때 일시가 중첩되어 예약될 수 없고, 서버에서 먼저 처리되는 1건만 예약

=> DB merge into

'''