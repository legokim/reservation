package com.app.reservation.domain.reserve.service;

import com.app.reservation.domain.member.repository.MemberRepository;
import com.app.reservation.domain.reserve.repository.Reservation;
import com.app.reservation.domain.reserve.repository.ReservationJPARepository;
import com.app.reservation.domain.room.repository.RoomRepository;
import com.app.reservation.exception.ExistReservationFoundException;
import com.app.reservation.exception.MemberNotFoundException;
import com.app.reservation.exception.RoomNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationJPARepository reservationJPARepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Reservation addReservation(Reservation param) {
        isMember(param.getMemNo());
        isRoom(param.getRoomNo());
        isExistReservation(param.getRoomNo(), param.getStartDt(), param.getEndDt());
        return reservationJPARepository.saveAndFlush(param);
    }

    @Override
    @Transactional
    public List<Reservation> addReservationRepeat(Reservation param) {
        List<Reservation> result = new ArrayList<>();
        for (int i = 1; i <= param.getRepeatCnt(); i++) {
            Reservation reservation = Reservation.builder()
                    .memNo(param.getMemNo())
                    .roomNo(param.getRoomNo())
                    .startDt(param.getStartDt().plusWeeks(i))
                    .endDt(param.getEndDt().plusWeeks(i))
                    .build();
            result.add(this.addReservation(reservation));
        }
        return result;
    }

    @Override
    public List<Reservation> findAllReservationByYearMonthDay(String yearMonthDay) {
        List<Reservation> result = reservationJPARepository.findAllReservationByYearMonthDay(yearMonthDay);
        return result;
    }

    @Override
    public List<Reservation> findAllReservationByMemNoAndYearMonthDay(Long memberNo, String yearMonthDay) {
        List<Reservation> result = reservationJPARepository.findAllReservationByMemNoAndYearMonthDay(yearMonthDay, memberNo);
        return result;
    }

    private void isMember(long memNo) {
        if(!memberRepository.findById(memNo).isPresent()){
            throw new MemberNotFoundException(String.valueOf(memNo));
        }
    }

    private void isRoom(long roomNo) {
        if(!roomRepository.findById(roomNo).isPresent()){
            throw new RoomNotFoundException(String.valueOf(roomNo));
        }
    }

    private void isExistReservation(long roomNo, LocalDateTime startDt, LocalDateTime endDt) {
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        if(!result.isEmpty()){
            throw new ExistReservationFoundException(startDt + "~" + endDt);
        }
    }
}
