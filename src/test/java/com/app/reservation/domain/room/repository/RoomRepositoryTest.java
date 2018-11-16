package com.app.reservation.domain.room.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "h2")
public class RoomRepositoryTest {

    private long roomNo;

    @Before
    public void setUp() throws Exception {
        roomNo = 101;
    }

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void findRoomById() {
        Room room = roomRepository.findById(roomNo).orElse(null);
        assertThat(room).isNotNull();
        assertThat(room.getRoomNo()).isEqualTo(roomNo);
    }

    @Test
    public void findRoomById_nullCheck() {
        Room room = roomRepository.findById(1002L).orElse(null);
        assertThat(room).isNull();
    }
}
