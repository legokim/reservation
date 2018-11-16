package com.app.reservation.domain.reserve.service;

import com.app.reservation.api.v1.dto.ReservationRequestDtoV1;
import com.app.reservation.domain.reserve.repository.Reservation;
import com.app.reservation.exception.ExistReservationFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "h2")
public class ReservationServiceTest {
    final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    @Autowired
    private ReservationService reservationService;
    private ReservationRequestDtoV1 reservation;
    private long memNo;

    @Before
    public void setUp() throws Exception {
        memNo = 10001;
        reservation = new ReservationRequestDtoV1();
        reservation.setRoomNo(101);
        reservation.setStartDt("201811061000");
        reservation.setEndDt("201811061100");
    }

    @Test
    public void saveReservation_one() {
        Reservation result = reservationService.addReservation(reservation.toEntity().memNo(memNo));
        assertThat(result).isNotNull();
        assertThat(result.getMemNo()).isEqualTo(memNo);
    }

    @Test
    public void saveReservation_반복_성공() {
        reservation.setRepeatCnt(3);
        List<Reservation> result = reservationService.addReservationRepeat(reservation.toEntity().memNo(memNo));
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test(expected = ExistReservationFoundException.class)
    public void saveReservation_반복_중간_실패() {
        reservation.setStartDt("201810291000");
        reservation.setEndDt("201810291100");
        reservation.setRepeatCnt(3);
        List<Reservation> result = reservationService.addReservationRepeat(reservation.toEntity().memNo(memNo));
        assertThat(result).isNullOrEmpty();
    }

    @Test
    public void findReservation_해당_날짜_예약내역조회() {
        String yearMonthDay = "20181005";
        List<Reservation> result = reservationService.findAllReservationByYearMonthDay(yearMonthDay);
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
    }
}
