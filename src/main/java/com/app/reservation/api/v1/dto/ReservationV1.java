package com.app.reservation.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationV1 {
    @ApiModelProperty(notes = "예약번호")
    private Long reserveNo;
    @ApiModelProperty(notes = "회원번호")
    private long memNo;
    @ApiModelProperty(notes = "회의실번호")
    private long roomNo;
    @ApiModelProperty(notes = "예약시작일")
    private LocalDateTime startDt;
    @ApiModelProperty(notes = "예약종료일")
    private LocalDateTime endDt;
    @ApiModelProperty(notes = "반복횟수")
    private int repeatCnt;
}
