package com.nmz.mapreview.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/1/2-23:47
 */
@SpringBootTest
class ReviewRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(ReviewRepositoryTest.class);

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void updateByReviewId() {
        reviewRepository.updateReviewByReviewId(1L, "test", Instant.now().toEpochMilli());
    }
}