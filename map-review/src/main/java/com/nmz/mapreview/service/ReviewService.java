package com.nmz.mapreview.service;

import com.nmz.mapreview.entity.ReviewEntity;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/5-13:48
 */
public interface ReviewService {

    void addReview(ReviewEntity review);

    void updateReview(ReviewEntity review);

    void deleteReview(ReviewEntity review);

}
