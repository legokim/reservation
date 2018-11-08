package com.app.reservation.v1;

import com.app.reservation.api.ControllerExceptionHandler;
import com.app.reservation.api.v1.ReservationControllerV1;
import com.app.reservation.api.v1.dto.ReservationRequestDtoV1;
import com.app.reservation.domain.reserve.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
//@Profile(value = "local")
public class ReservationControllerV1Test {

    private MockMvc mvc;
    private ObjectMapper mapper;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ReservationService reservationService;

    private ReservationRequestDtoV1 dtoV1;

    @Before
    public void setUp() throws Exception {
        mapper = new ObjectMapper();
        mvc = MockMvcBuilders
            .standaloneSetup(
                new ReservationControllerV1(modelMapper, reservationService))
            .setControllerAdvice(new ControllerExceptionHandler())
            .build();

        dtoV1 = new ReservationRequestDtoV1();
        dtoV1.setRoomNo(101);
        dtoV1.setStartDt("201811061130");
        dtoV1.setEndDt("201811061230");
    }

    @Test
    public void save_Reservation_예약하기() throws Exception {
        mvc.perform(post("/reservation/v1/room/10001")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dtoV1)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void save_Reservation_예약하기_예약날짜_오류파라미터_실패() throws Exception {
        dtoV1.setStartDt("201811071230");
        mvc.perform(post("/reservation/v1/room/10001")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
