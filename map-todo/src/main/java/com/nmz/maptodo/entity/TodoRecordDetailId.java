package com.nmz.maptodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Embeddable
public class TodoRecordDetailId implements Serializable {
    private static final long serialVersionUID = 2161305692702638068L;
    @Column(name = "record_id", nullable = false)
    private Long recordId;

    @Column(name = "record_detail_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordDetailId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TodoRecordDetailId entity = (TodoRecordDetailId) o;
        return Objects.equals(this.recordId, entity.recordId) &&
                Objects.equals(this.recordDetailId, entity.recordDetailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, recordDetailId);
    }

    public TodoRecordDetailId() {
    }

    public TodoRecordDetailId(Long recordId) {
        this.recordId = recordId;
    }

    public TodoRecordDetailId(Long recordId, Long recordDetailId) {
        this.recordId = recordId;
        this.recordDetailId = recordDetailId;
    }
}