package com.nmz.maptodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todo_record", schema = "map")
public class TodoRecord {
    @Id
    @Column(name = "record_id", nullable = false)
    private Integer id;

    @Column(name = "record_title")
    private String recordTitle;

    @Column(name = "record_is_delete")
    private Boolean recordIsDelete;

    @Column(name = "record_locked")
    private Boolean recordLocked;

    @CreatedDate
    @Column(name = "record_create_time")
    private Date recordCreateTime;

    @LastModifiedDate
    @Column(name = "record_update_time")
    private Date recordUpdateTime;
}