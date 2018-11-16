package com.app.reservation.domain.reserve.repository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findExistReservation(long roomNo, LocalDateTime startDt, LocalDateTime endDt);
}
