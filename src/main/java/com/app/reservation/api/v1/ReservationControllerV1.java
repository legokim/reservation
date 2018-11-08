package com.app.reservation.api.v1;

import com.app.reservation.api.v1.dto.ReservationRequestDtoV1;
import com.app.reservation.api.v1.dto.ReservationV1;
import com.app.reservation.common.validation.ReservationDateValid;
import com.app.reservation.domain.reserve.repository.Reservation;
import com.app.reservation.domain.reserve.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/reservation/v1")
@Api(value = "/reservation/v1", description = "회의실예약", tags = {"Reservation - 회의실"})
@ApiResponses(value = {
    @ApiResponse(code = 400, message = "Wrong Type Parameter"),
    @ApiResponse(code = 404, message = "Reservation not found"),
    @ApiResponse(code = 500, message = "Server Error")})
public class ReservationControllerV1 {

    @NonNull
    private final ModelMapper modelMapper;

    @NonNull
    private final ReservationService reservationService;

    @ApiOperation(value = "예약하기",
                  notes = "예약하기 (ex. startDt : 201811061130 (년도+월+일+시+분), endDt : 201811061230 (년도+월+일+시+분)")
    @RequestMapping(value = "/room/{memberNo}", method = RequestMethod.POST)
    public  List<ReservationV1> saveReservation(
        @PathVariable Long memberNo,
        @Valid @RequestBody @ReservationDateValid ReservationRequestDtoV1 dtoV1
    ) {
        List<Reservation> reservationV1List = reservationService.addReservationRepeat(dtoV1.toEntity().memNo(memberNo));
        return reservationV1List.stream()
                .map(d -> modelMapper.map(d, ReservationV1.class))
                .collect(Collectors.toList());
    }
}
