package com.nmz.maptodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todo_record_detail", schema = "map")
public class TodoRecordDetail {
    @EmbeddedId
    private TodoRecordDetailId id;

    @Column(name = "detail_checked")
    private Boolean detailChecked;

    @Column(name = "detail_is_delete")
    private Boolean detailIsDelete;

    @Column(name = "detail_text")
    private String detailText;

    @CreatedDate
    @Column(name = "detail_create_time", updatable = false)
    private Date detailCreateTime;

    @LastModifiedDate
    @Column(name = "detail_update_time")
    private Date detailUpdateTime;

}