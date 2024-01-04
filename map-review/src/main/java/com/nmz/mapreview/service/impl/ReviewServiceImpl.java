package com.nmz.mapreview.service.impl;

import com.nmz.mapreview.entity.ReviewEntity;
import com.nmz.mapreview.mapper.ReviewRepository;
import com.nmz.mapreview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/5-13:48
 */
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public void addReview(ReviewEntity review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(ReviewEntity review) {
        reviewRepository.updateReviewByReviewId(review.getReviewId().getReviewId(), review.getReviewContent(), review.getReviewUpdateTime());
    }

    @Override
    public void deleteReview(ReviewEntity review) {
        reviewRepository.delete(review);
    }
}
