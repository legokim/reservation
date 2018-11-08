package com.app.reservation.domain.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @Column
    @GeneratedValue
    private long roomNo;

    @Column
    private String roomName;

//    @OneToMany(cascade = CascadeType.ALL, ALLmappedBy = "room", fetch = FetchType.LAZY)
//    private Collection<Schedule> schedule;

    public Room(String roomName) {
        this.roomName = roomName;
    }
}
