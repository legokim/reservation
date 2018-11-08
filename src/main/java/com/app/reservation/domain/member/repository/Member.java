package com.app.reservation.domain.member.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @Column
    @GeneratedValue
    private Long memNo;

    @Column
    private String memName;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member", fetch = FetchType.LAZY)
//    private Collection<Reservation> reservations;

    public Member(String memName) {
        this.memName = memName;
    }
}
