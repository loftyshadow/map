package com.nmz.mapreview.mapper;

import com.nmz.mapreview.entity.ReviewEntity;
import com.nmz.mapreview.entity.ReviewId;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/1/12-16:51
 */
@Repository
public interface ESReviewRepository extends ElasticsearchRepository<ReviewEntity, ReviewId> {
}
