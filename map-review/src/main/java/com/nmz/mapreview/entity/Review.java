package com.nmz.mapreview.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Description: 评论
 * @Author: 聂明智
 * @Date: 2023/11/30-19:30
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todo_review", schema = "map")
public class Review {
    @EmbeddedId
    private ReviewId reviewId;

    @Lob
    @Column(name = "review_content")
    private String reviewContent;

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
}
