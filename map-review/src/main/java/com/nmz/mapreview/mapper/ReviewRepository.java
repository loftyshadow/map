package com.nmz.mapreview.mapper;

import com.nmz.mapreview.entity.ReviewEntity;
import com.nmz.mapreview.entity.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, ReviewId> {

    @Transactional
    @Modifying
    @Query(value = "update ReviewEntity r set r.reviewContent = ?2, r.reviewUpdateTime = ?3 where r.reviewId=?1", nativeQuery = true)
    void updateReviewByReviewId(Long reviewId, String reviewContent, Long reviewUpdateTime);

}