package com.app.reservation.api.v1.dto;

import com.app.reservation.domain.reserve.repository.Reservation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ReservationRequestDtoV1 {

    @ApiModelProperty(notes = "회의실번호")
    @Min(value = 1, message = "회의실번호는 필수 입니다.")
    private long roomNo;

    @ApiModelProperty(notes = "예약시작시간")
    private String startDt;

    @ApiModelProperty(notes = "예약종료시간")
    private String endDt;

    @ApiModelProperty(notes = "반복횟수")
    private int repeatCnt = 1;

    public Reservation toEntity(){
        return Reservation.builder()
                          .roomNo(roomNo)
                          .repeatCnt(repeatCnt <= 0 ? 1 : repeatCnt )
                          .build()
                          .startDt(startDt)
                          .endDt(endDt);
    }
}
