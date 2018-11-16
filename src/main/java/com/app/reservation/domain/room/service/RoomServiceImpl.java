package com.app.reservation.domain.room.service;

import com.app.reservation.domain.room.repository.Room;
import com.app.reservation.domain.room.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Optional<List<Room>> frindRoom() {
        return Optional.ofNullable(roomRepository.findAll());
    }
}
