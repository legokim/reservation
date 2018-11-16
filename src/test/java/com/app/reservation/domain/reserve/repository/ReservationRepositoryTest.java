package com.app.reservation.domain.reserve.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "h2")
public class ReservationRepositoryTest {

    final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    @Autowired
    private ReservationJPARepository reservationJPARepository;

    private Reservation param;
    private int roomNo;

    @Before
    public void setUp() throws Exception {
        roomNo = 101;
        param = Reservation.builder()
                .roomNo(roomNo)
                .startDt(LocalDateTime.parse("201811051000", dateFormat))
                .endDt(LocalDateTime.parse("201811051100", dateFormat))
                .build().memNo(10001);
    }

    @Transactional
    @Test
    public void saveReservation_예약하기() {
        Reservation result = reservationJPARepository.saveAndFlush(param);
        assertThat(result).isNotNull();
        assertThat(result.getStartDt()).isEqualTo(param.getStartDt());
    }

    @Test
    public void findExistReservation_같은시간() {
        LocalDateTime startDt = param.getStartDt();
        LocalDateTime endDt = param.getEndDt();
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void findExistReservation_시작시간전부터() {
        LocalDateTime startDt = param.getStartDt().minusMinutes(30);
        LocalDateTime endDt = param.getStartDt();
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    public void findExistReservation_종료시간후부터() {
        LocalDateTime startDt = param.getEndDt();
        LocalDateTime endDt = param.getEndDt().plusMinutes(30);
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    public void findExistReservation_기준시간_앞뒤_포함() {
        LocalDateTime startDt = param.getStartDt().minusMinutes(30);
        LocalDateTime endDt = param.getEndDt().plusMinutes(30);
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void findExistReservation_기준시간_시작시간만_포함() {
        LocalDateTime startDt = param.getStartDt().minusMinutes(30);
        LocalDateTime endDt = param.getStartDt().plusMinutes(30);
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void findExistReservation_기준시간_종료시간만_포함() {
        LocalDateTime startDt = param.getEndDt().minusMinutes(30);
        LocalDateTime endDt = param.getEndDt().plusMinutes(30);
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void findReservation_해당_날짜_예약내역조회() {
        String yearMonthDay = "20181005";
        List<Reservation> result = reservationJPARepository.findAllReservationByYearMonthDay(yearMonthDay);
        assertThat(result.size()).isGreaterThan(0);
        assertThat(result.size()).isEqualTo(3);
    }
}

