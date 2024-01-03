package com.nmz.mapreview.service;

import com.nmz.mapreview.entity.Review;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/5-13:48
 */
public interface ReviewService {

    void addReview(Review review);

    void updateReview(Review review);

    void deleteReview(Review review);

}
