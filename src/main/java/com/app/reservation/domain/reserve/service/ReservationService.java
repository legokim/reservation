package com.app.reservation.domain.reserve.service;

import com.app.reservation.domain.reserve.repository.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    List<Reservation> addReservationRepeat(Reservation reservation);

    List<Reservation> findAllReservationByYearMonthDay(String yearMonthDay);

    List<Reservation> findAllReservationByMemNoAndYearMonthDay(Long memberNo, String yearMonthDay);
}
