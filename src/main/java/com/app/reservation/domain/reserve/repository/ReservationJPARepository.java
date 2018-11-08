package com.app.reservation.domain.reserve.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationJPARepository extends JpaRepository<Reservation, Long> {

    @Query(value="SELECT r FROM Reservation r  where roomNo = ?1 "
            + "and (( (?2 >= startDt and ?2 < end_dt) or (?3 > startDt and ?3 < end_dt))"
            + " or ( (startDt > ?2 and startDt < ?3) or (endDt > ?2 and endDt < ?3)))"
            )
    List<Reservation> findExistReservation(@Param("roomNo") long roomNo,
                                           @Param("startDt") LocalDateTime startDt,
                                           @Param("endDt") LocalDateTime endDt);

}
