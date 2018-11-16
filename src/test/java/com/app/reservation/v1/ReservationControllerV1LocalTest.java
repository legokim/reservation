package com.app.reservation.v1;

import com.app.reservation.api.v1.dto.ReservationRequestDtoV1;
import com.app.reservation.api.v1.dto.ReservationV1;
import com.app.reservation.domain.room.repository.RoomRepository;
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

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "local")
@RunWith(SpringRunner.class)
@Transactional
public class ReservationControllerV1LocalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RoomRepository roomRepository;

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
        dtoV1.setStartDt("201812071130");
        dtoV1.setEndDt("201812071230");
        dtoV1.setRepeatCnt(1);
        List<ReservationV1> result = getRestCall(dtoV1);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    public void save_Reservation_예약하기_반복() {
        dtoV1 = new ReservationRequestDtoV1();
        dtoV1.setRoomNo(roomNo);
        dtoV1.setStartDt("201812061130");
        dtoV1.setEndDt("201812061230");
        dtoV1.setRepeatCnt(3);
        List<ReservationV1> result = getRestCall(dtoV1);
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(3);
    }

    private List<ReservationV1> getRestCall(ReservationRequestDtoV1 dtoV1) {
        HttpEntity entity = new HttpEntity(dtoV1);

        ResponseEntity<List<ReservationV1>> responseEntity =
                restTemplate.exchange("/reservation/v1/room/10001",
                        HttpMethod.POST,
                        entity,
                        new ParameterizedTypeReference<List<ReservationV1>>() {
                        });

        return responseEntity.getBody();
    }

    @Test
    public void findAllReservation_일_예약내역조회() {
        ResponseEntity<List<ReservationV1>> responseEntity =
                restTemplate.exchange("/reservation/v1/20181005"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<List<ReservationV1>>() {
                        });
        List<ReservationV1> result = responseEntity.getBody();
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    public void findAllReservation_월_예약내역조회() {
        ResponseEntity<List<ReservationV1>> responseEntity =
                restTemplate.exchange("/reservation/v1/201810"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<List<ReservationV1>>() {
                        });
        List<ReservationV1> result = responseEntity.getBody();
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }


    @Test(expected= Exception.class)
    public void findAllReservation_월_일_예약내역조회_실패() {
        ResponseEntity<List<ReservationV1>> responseEntity =
                restTemplate.exchange("/reservation/v1/20181035"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<List<ReservationV1>>() {
                        });
    }
}
