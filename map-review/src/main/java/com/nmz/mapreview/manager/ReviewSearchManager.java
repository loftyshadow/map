package com.nmz.mapreview.manager;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.nmz.mapreview.constant.EsindexEnum;
import com.nmz.mapreview.dto.EsPageDTO;
import com.nmz.mapreview.dto.ReviewDTO;
import com.nmz.mapreview.vo.EsPageVO;
import com.nmz.mapreview.vo.EsReviewVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.nmz.mapreview.exception.EsSearchException.SEARCH_FAILED;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/29-14:44
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ReviewSearchManager {

    private final ElasticsearchClient elasticsearchClient;

    /**
     * 通过搜索信息分页搜索es数据的信息
     *
     * @param pageDTO   分页数据
     * @param ReviewDTO 订单搜索条件
     * @return 搜索结果
     */
    public EsPageVO<EsReviewVO> pageSearchResult(EsPageDTO pageDTO, ReviewDTO ReviewDTO) {
        // 1、动态构建出查询需要的DSL语句
        EsPageVO<EsReviewVO> result;

        // 1、准备检索请求
        SearchRequest searchRequest = buildSearchRequest(pageDTO, ReviewDTO);

        try {
            // 2、执行检索请求
            SearchResponse<EsReviewVO> response = elasticsearchClient.search(searchRequest, EsReviewVO.class);
            log.debug("搜索返回结果：" + response.toString());

            // 3、分析响应数据，封装成我们需要的格式
            result = buildSearchResult(pageDTO, response);
        } catch (IOException e) {
            log.error(e.toString());
            throw SEARCH_FAILED;
        }
        return result;
    }

    /**
     * 构建结果数据
     */
    private EsPageVO<EsReviewVO> buildSearchResult(EsPageDTO pageDTO, SearchResponse<EsReviewVO> response) {
        EsPageVO<EsReviewVO> esPageVO = new EsPageVO<>();

        // 1、返回的所有查询到的商品
        List<Hit<EsReviewVO>> hits = response.hits().hits();
        List<EsReviewVO> reviewVOList = getEsOrderBOList(response);
        esPageVO.setList(reviewVOList);


        //===============分页信息====================//
        // 总记录数
        long total = hits.size();
        esPageVO.setTotal(total);
        // 总页码
        int totalPages = (int) total % pageDTO.getPageSize() == 0 ?
                (int) total / pageDTO.getPageSize() : ((int) total / pageDTO.getPageSize() + 1);
        esPageVO.setPages(totalPages);
        return esPageVO;
    }

    private List<EsReviewVO> getEsOrderBOList(SearchResponse<EsReviewVO> response) {
        return getReviewListByResponse(response.hits().hits());
    }

    /**
     * 从es返回的数据中获取review列表
     *
     * @param hits es返回的数据
     * @return
     */
    private List<EsReviewVO> getReviewListByResponse(List<Hit<EsReviewVO>> hits) {
        List<EsReviewVO> esOrders = new ArrayList<>();
        for (Hit<EsReviewVO> hit : hits) {
            EsReviewVO esOrder;
            esOrder = hit.source();
            esOrders.add(esOrder);
        }
        return esOrders;
    }

    private SearchRequest buildSearchRequest(EsPageDTO pageDTO, ReviewDTO param) {

        SearchRequest.Builder searchSourceBuilder = new SearchRequest.Builder();
        searchSourceBuilder.index(EsindexEnum.REVIEW.value());

        // 构建bool-query
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        // 过滤
        filterQueryIfNecessary(param, boolQueryBuilder);

        // 关键字搜索
        keywordSearch(param, boolQueryBuilder);

        // 排序
        sort(searchSourceBuilder, boolQueryBuilder);

        // 分页
        if (Objects.nonNull(pageDTO)) {
            searchSourceBuilder.from((pageDTO.getPageNum() - 1) * pageDTO.getPageSize());
            searchSourceBuilder.size(pageDTO.getPageSize());
        }

        log.debug("构建的DSL语句 {}", searchSourceBuilder);

        return searchSourceBuilder.build();
    }

    /**
     * 过滤查询条件，如果有必要的话
     *
     * @param param            查询条件
     * @param boolQueryBuilder 组合进boolQueryBuilder
     */
    private void filterQueryIfNecessary(ReviewDTO param, BoolQuery.Builder boolQueryBuilder) {

        // 用户id
        if (Objects.nonNull(param.userId())) {
            boolQueryBuilder.filter(q ->
                    q.match(t -> t.field("userId").query(param.userId())));
        }

        // 开始时间 - 结束时间
        Long startTime = param.startTime();
        Long endTime = param.endTime();
        if (startTime != null || endTime != null) {
            // 创建时间
            String createTime = "createTime";
            RangeQuery.Builder rangeQueryBuilder = new RangeQuery.Builder();
            rangeQueryBuilder.field(createTime);
            if (startTime != null) {
                rangeQueryBuilder.gte(JsonData.of(startTime));
            }
            if (endTime != null) {
                rangeQueryBuilder.lte(JsonData.of(endTime));
            }
            Query rangeTime = rangeQueryBuilder.build()._toQuery();
            boolQueryBuilder.filter(rangeTime);
        }

    }

    /**
     * 关键字搜索
     */
    private void keywordSearch(ReviewDTO param, BoolQuery.Builder boolQueryBuilder) {

        // 创建查询语句 ES中must和should不能同时使用 同时使用should失效 嵌套多个must 将should条件拼接在一个must中即可
        BoolQuery.Builder keywordShouldQueryBuilder = QueryBuilders.bool();

        // 评论id
        if (param.reviewId() != null) {
            boolQueryBuilder.must(q -> q.match(t -> t.field("reviewId").query(param.reviewId())));
        }

        // 评论内容
        if (StringUtils.hasText(param.reviewContent())) {
            keywordShouldQueryBuilder.should(q -> q.match(t -> t.field("reviewContent").query(param.reviewContent())));
        }

        boolQueryBuilder.must(keywordShouldQueryBuilder.build()._toQuery());
    }

    /**
     * 进行排序
     */
    private void sort(SearchRequest.Builder searchSourceBuilder, BoolQuery.Builder boolQueryBuilder) {
        searchSourceBuilder.sort(
                f -> f.field(
                        o -> o.field("createTime")
                                .order(SortOrder.Desc)));
        searchSourceBuilder.query(boolQueryBuilder.build()._toQuery());
    }

}
