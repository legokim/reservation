package com.app.reservation.domain.reserve.service;

import com.app.reservation.domain.member.repository.MemberRepository;
import com.app.reservation.domain.repository.RoomRepository;
import com.app.reservation.domain.reserve.repository.Reservation;
import com.app.reservation.domain.reserve.repository.ReservationJPARepository;
import com.app.reservation.exception.ExistResultFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {

    private MemberRepository memberRepository;
    private RoomRepository roomRepository;
    private ReservationJPARepository reservationJPARepository;

    public ReservationServiceImpl(MemberRepository memberRepository,
                                  RoomRepository roomRepository,
                                  ReservationJPARepository reservationJPARepository) {
        this.memberRepository = memberRepository;
        this.roomRepository = roomRepository;
        this.reservationJPARepository = reservationJPARepository;
    }

    @Override
    public Reservation addReservation(Reservation param) {
        if(isExistReservation(param.getRoomNo(), param.getStartDt(), param.getEndDt())){
            throw new ExistResultFoundException(param.getStartDt() + "~" + param.getEndDt());
        }
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


    private boolean isExistReservation(long roomNo, LocalDateTime startDt, LocalDateTime endDt) {
        List<Reservation> result = reservationJPARepository.findExistReservation(roomNo, startDt, endDt);
        return !result.isEmpty();
    }
}
