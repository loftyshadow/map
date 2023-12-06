package com.nmz.maptrip.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class VisitedCityId implements Serializable {

    @Column(name = "user_id", unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long userId;

    @Column(name = "review_id", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitCityId;

}