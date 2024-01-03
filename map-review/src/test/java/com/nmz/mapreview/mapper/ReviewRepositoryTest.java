package com.nmz.mapreview.mapper;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/1/2-23:47
 */
@SpringBootTest
@Slf4j
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void updateByReviewId() {
        reviewRepository.updateByReviewId("test", new Date());
    }
}