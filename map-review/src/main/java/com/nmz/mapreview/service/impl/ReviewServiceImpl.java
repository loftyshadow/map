package com.nmz.mapreview.service.impl;

import com.nmz.mapreview.entity.Review;
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
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.updateReviewByReviewId(review.getReviewId().getReviewId(), review.getReviewContent(), review.getReviewUpdateTime());
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.delete(review);
    }
}
