package com.app.reservation.domain.reserve.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {

//    @Qualifier("jpaHelper")
//    private final JpaHelper jpaHelper;
//    private final OpenJPATemplates jpaTemplates;

    public Optional<Reservation> addReservation() {

        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findExistReservation(long roomNo, LocalDateTime startDt, LocalDateTime endDt) {

        return Optional.empty();
    }



}
