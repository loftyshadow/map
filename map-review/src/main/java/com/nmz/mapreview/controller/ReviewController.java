package com.nmz.mapreview.controller;

import com.nmz.mapreview.entity.ReviewEntity;
import com.nmz.mapreview.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/5-13:42
 */
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@Tag(name = "ReviewController", description = "评论ReviewController")
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    public void addReview(ReviewEntity review) {
        reviewService.addReview(review);
    }

    public void updateReview(ReviewEntity review) {
        reviewService.updateReview(review);
    }

    public void deleteReview(ReviewEntity review) {
        reviewService.deleteReview(review);
    }

}
