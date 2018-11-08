package com.app.reservation.domain.reserve.repository;

import com.app.reservation.domain.common.repository.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVE_NO", updatable = false, nullable = false)
    private Long reserveNo;

    @Column
    @Setter
    private long memNo;

    @Column
    private long roomNo;

    @Setter
    @Column
    private LocalDateTime startDt;

    @Setter
    @Column
    private LocalDateTime endDt;

    @Column
    private int repeatCnt;

    @Builder
    public Reservation(long memNo, long roomNo, LocalDateTime startDt, LocalDateTime endDt,int repeatCnt) {
        this.memNo = memNo;
        this.roomNo = roomNo;
        this.startDt = startDt;
        this.endDt = endDt;
        this.repeatCnt = repeatCnt;
    }

    public Reservation memNo(long memNo){
        this.memNo = memNo;
        return this;
    }
    public Reservation startDt(String startDt){
        this.startDt = LocalDateTime.parse(startDt, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        return this;
    }
    public Reservation endDt(String endDt){
        this.endDt = LocalDateTime.parse(endDt, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        return this;
    }
}
