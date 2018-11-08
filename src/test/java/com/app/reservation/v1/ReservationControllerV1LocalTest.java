package com.app.reservation.v1;

import com.app.reservation.api.v1.dto.ReservationRequestDtoV1;
import com.app.reservation.api.v1.dto.ReservationV1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "local")
@RunWith(SpringRunner.class)
public class ReservationControllerV1LocalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private ReservationRequestDtoV1 dtoV1;
    private int roomNo;

    @Before
    public void setUp() throws Exception {
        dtoV1 = new ReservationRequestDtoV1();
        roomNo = 1001;
        dtoV1.setRoomNo(roomNo);
    }

    @Test
    public void save_Reservation_예약하기() {
        dtoV1 = new ReservationRequestDtoV1();
        dtoV1.setRoomNo(roomNo);
        dtoV1.setStartDt("201811071130");
        dtoV1.setEndDt("201811071230");
        dtoV1.setRepeatCnt(1);
        List<ReservationV1> result = getRestCall(dtoV1);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    public void save_Reservation_예약하기_반복() {
        dtoV1 = new ReservationRequestDtoV1();
        dtoV1.setRoomNo(roomNo);
        dtoV1.setStartDt("201811061130");
        dtoV1.setEndDt("201811061230");
        dtoV1.setRepeatCnt(3);
        List<ReservationV1> result = getRestCall(dtoV1);
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(3);
    }

    private List<ReservationV1> getRestCall(ReservationRequestDtoV1 dtoV1) {
        HttpEntity entity = new HttpEntity(dtoV1);

        ResponseEntity<List<ReservationV1>> responseEntity =
                restTemplate.exchange("/reservation/v1/room/10001"
                        , HttpMethod.POST
                        , entity
                        , new ParameterizedTypeReference<List<ReservationV1>>() {
                        });

        return responseEntity.getBody();
    }
}
