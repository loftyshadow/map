package com.nmz.maptodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todo_record", schema = "map")
public class TodoRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordTitle() {
        return recordTitle;
    }

    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle;
    }

    public Boolean getRecordIsDelete() {
        return recordIsDelete;
    }

    public void setRecordIsDelete(Boolean recordIsDelete) {
        this.recordIsDelete = recordIsDelete;
    }

    public Boolean getRecordLocked() {
        return recordLocked;
    }

    public void setRecordLocked(Boolean recordLocked) {
        this.recordLocked = recordLocked;
    }

    public Date getRecordCreateTime() {
        return recordCreateTime;
    }

    public void setRecordCreateTime(Date recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }

    public Date getRecordUpdateTime() {
        return recordUpdateTime;
    }

    public void setRecordUpdateTime(Date recordUpdateTime) {
        this.recordUpdateTime = recordUpdateTime;
    }
}