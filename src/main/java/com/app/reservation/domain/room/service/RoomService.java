package com.app.reservation.domain.room.service;

import com.app.reservation.domain.room.repository.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    public Optional<List<Room>> frindRoom();
}
