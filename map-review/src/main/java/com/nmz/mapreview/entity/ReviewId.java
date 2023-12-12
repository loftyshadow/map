package com.nmz.mapreview.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Getter
@Setter
@Schema(title = "评论Id")
@Embeddable
public class ReviewId implements Serializable {

    @Schema(name = "用户ID", description = "用户ID属性", format = "int64", example = "1")
    @Column(name = "user_id", unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long userId;

    @Schema(name = "评论ID", description = "评论ID属性", format = "int64", example = "1")
    @Column(name = "review_id", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long reviewId;

}