package com.nmz.mapreview.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * @Description: 评论
 * @Author: 聂明智
 * @Date: 2023/11/30-19:30
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Schema(title = "评论", description = "用户评论")
@Table(name = "mapo_review", schema = "map")
public class Review {
    @EmbeddedId
    private ReviewId reviewId;

    @Schema(name = "评论内容", description = "用户评论内容", format = "text", example = "wonderful")
    @Lob
    @Column(name = "review_content")
    private String reviewContent;

    @CreatedDate
    @Column(name = "review_create_time", updatable = false)
    private Date reviewCreateTime;

    @LastModifiedDate
    @Column(name = "review_update_time")
    private Date reviewUpdateTime;

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public ReviewId getReviewId() {
        return reviewId;
    }

    public void setReviewId(ReviewId reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewCreateTime() {
        return reviewCreateTime;
    }

    public void setReviewCreateTime(Date reviewCreateTime) {
        this.reviewCreateTime = reviewCreateTime;
    }

    public Date getReviewUpdateTime() {
        return reviewUpdateTime;
    }

    public void setReviewUpdateTime(Date reviewUpdateTime) {
        this.reviewUpdateTime = reviewUpdateTime;
    }
}
