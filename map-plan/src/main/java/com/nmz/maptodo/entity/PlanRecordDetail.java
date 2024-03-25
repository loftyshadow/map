package com.nmz.maptodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "plan_record_detail", schema = "map")
public class PlanRecordDetail {
    @EmbeddedId
    private PlanRecordDetailId id;

    @Column(name = "detail_checked")
    private Boolean detailChecked;

    @Column(name = "detail_is_delete")
    private Boolean detailIsDelete;

    @Column(name = "detail_text")
    private String detailText;

    @CreatedDate
    @Column(name = "detail_create_time", updatable = false)
    private Long detailCreateTime;

    @LastModifiedDate
    @Column(name = "detail_update_time")
    private Long detailUpdateTime;

    public PlanRecordDetailId getId() {
        return id;
    }

    public void setId(PlanRecordDetailId id) {
        this.id = id;
    }

    public Boolean getDetailChecked() {
        return detailChecked;
    }

    public void setDetailChecked(Boolean detailChecked) {
        this.detailChecked = detailChecked;
    }

    public Boolean getDetailIsDelete() {
        return detailIsDelete;
    }

    public void setDetailIsDelete(Boolean detailIsDelete) {
        this.detailIsDelete = detailIsDelete;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    public Long getDetailCreateTime() {
        return detailCreateTime;
    }

    public void setDetailCreateTime(Long detailCreateTime) {
        this.detailCreateTime = detailCreateTime;
    }

    public Long getDetailUpdateTime() {
        return detailUpdateTime;
    }

    public void setDetailUpdateTime(Long detailUpdateTime) {
        this.detailUpdateTime = detailUpdateTime;
    }
}