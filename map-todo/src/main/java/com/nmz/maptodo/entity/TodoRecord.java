package com.nmz.maptodo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
@Schema(title = "待办事项")
@Table(name = "todo_record", schema = "map")
public class TodoRecord {
    @EmbeddedId
    private TodoRecordId id;

    @Schema(name = "待办事项标题", description = "待办事项标题", example = "吃饭")
    @Column(name = "record_title")
    private String recordTitle;

    @Schema(name = "待办事项是否删除", description = "待办事项是否删除", example = "false")
    @Column(name = "record_is_delete")
    private Boolean recordIsDelete;

    @Schema(name = "待办事项是否锁定", description = "待办事项是否锁定", example = "false")
    @Column(name = "record_locked")
    private Boolean recordLocked;

    @Schema(name = "待办事项创建时间", description = "待办事项创建时间", example = "2021-08-12 12:12:12")
    @CreatedDate
    @Column(name = "record_create_time")
    private Date recordCreateTime;

    @Schema(name = "待办事项更新时间", description = "待办事项更新时间", example = "2021-08-12 12:12:12")
    @LastModifiedDate
    @Column(name = "record_update_time")
    private Date recordUpdateTime;

    public TodoRecordId getId() {
        return id;
    }

    public void setId(TodoRecordId id) {
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