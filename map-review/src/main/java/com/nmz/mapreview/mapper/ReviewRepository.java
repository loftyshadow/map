package com.nmz.mapreview.mapper;

import com.nmz.mapreview.entity.Review;
import com.nmz.mapreview.entity.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {

    @Transactional
    @Modifying
    @Query("update Review r set r.reviewContent = ?2, r.reviewUpdateTime = ?3 where r.reviewId=?1")
    int updateReviewByReviewId(Long reviewId, String reviewContent, Date reviewUpdateTime);

}