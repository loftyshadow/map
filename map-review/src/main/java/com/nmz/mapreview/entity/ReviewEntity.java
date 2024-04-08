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

/**
 * @Description: 评论
 * @Author: 聂明智
 * @Date: 2023/11/30-19:30
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Schema(title = "评论", description = "用户评论")
@Table(name = "map_review")
public class ReviewEntity {
    @EmbeddedId
    private ReviewId reviewId;

    @Schema(name = "评论内容", description = "用户评论内容", format = "text", example = "wonderful")
    @Lob
    @Column(name = "review_content")
    private String reviewContent;

    @CreatedDate
    @Column(name = "review_create_time", updatable = false)
    private Long reviewCreateTime;

    @LastModifiedDate
    @Column(name = "review_update_time")
    private Long reviewUpdateTime;

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

    public Long getReviewCreateTime() {
        return reviewCreateTime;
    }

    public void setReviewCreateTime(Long reviewCreateTime) {
        this.reviewCreateTime = reviewCreateTime;
    }

    public Long getReviewUpdateTime() {
        return reviewUpdateTime;
    }

    public void setReviewUpdateTime(Long reviewUpdateTime) {
        this.reviewUpdateTime = reviewUpdateTime;
    }

    public ReviewEntity() {
    }

    public ReviewEntity(ReviewId reviewId, String reviewContent, Long reviewCreateTime, Long reviewUpdateTime) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewCreateTime = reviewCreateTime;
        this.reviewUpdateTime = reviewUpdateTime;
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "reviewId=" + reviewId +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewCreateTime=" + reviewCreateTime +
                ", reviewUpdateTime=" + reviewUpdateTime +
                '}';
    }
}
