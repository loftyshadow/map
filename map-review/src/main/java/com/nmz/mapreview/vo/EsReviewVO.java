package com.nmz.mapreview.vo;

import com.nmz.mapreview.entity.ReviewId;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Lob;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/1/1-23:05
 */
public class EsReviewVO {

    @Schema(name = "用户ID", description = "用户ID属性", format = "int64", example = "1")
    private Long userId;

    @Schema(name = "评论ID", description = "评论ID属性", format = "int64", example = "1")
    private Long reviewId;

    @Schema(name = "评论内容", description = "用户评论内容", format = "text", example = "wonderful")
    private String reviewContent;

    private Date reviewCreateTime;

    private Date reviewUpdateTime;


}
