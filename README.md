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

# Comments 문제 해결.
```
1. 예약 시간은 30분 단위로 가능
=> Controller에서 유효성 체크 
    (시작/종료일 차이 30분 and 30 나머지 0)
    현 시각 이후 부터 예약 가능
    예약 시작 시간 > 종료시간

2.	주 단위 반복 예약 설정
	반복 요일, 횟수 지정
=> 선택 한 날짜 + week = 반복횟수 만큼 date 입력.

4.	동일한 일시 예약불가
 	종료 시각 = 시작 시가 중첩 아님
=> query time between.

6.	동시 접수 시 서버 먼저 처리 되는 1건만 예약
=>  merge into not matched insert
'''
