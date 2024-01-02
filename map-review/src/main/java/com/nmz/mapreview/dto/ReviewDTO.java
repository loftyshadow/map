package com.nmz.mapreview.dto;

import java.util.Date;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/1/1-23:00
 */
public record ReviewDTO(Long userId,
                        Long reviewId,
                        String reviewContent,
                        Long startTime,
                        Long endTime) {
}
