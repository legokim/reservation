package com.app.reservation.domain.common.repository;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createDt;

    @Column(nullable = false, updatable = true)
    @CreationTimestamp
    private LocalDateTime updateDt;
}
