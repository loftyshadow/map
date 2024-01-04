package com.nmz.mapreview.manager;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.cat.IndicesResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.elasticsearch.indices.IndexState;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import com.nmz.mapreview.entity.ReviewEntity;
import com.nmz.mapreview.entity.ReviewId;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/1/4-10:49
 */
@SpringBootTest
public class EsClientTest {

    private static final Logger log = LoggerFactory.getLogger(EsClientTest.class);

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Test
    void addIndex() throws IOException {
        CreateIndexResponse createIndexResponse = elasticsearchClient.indices().create(c -> c.index("reviews"));
        // 响应状态
        boolean acknowledged = createIndexResponse.acknowledged();
        boolean shardsAcknowledged = createIndexResponse.shardsAcknowledged();
        String index = createIndexResponse.index();
        log.info("创建索引状态:{}", acknowledged);
        log.info("已确认的分片:{}", shardsAcknowledged);
        log.info("索引名称:{}", index);
    }

    /**
     * 获取索引
     */
    @Test
    void getIndex() throws IOException {
        // 查看指定索引
        GetIndexResponse getIndexResponse = elasticsearchClient.indices().get(s -> s.index("reviews"));
        Map<String, IndexState> result = getIndexResponse.result();
        result.forEach((k, v) -> log.info("key = {},value = {}", k, v));

        // 查看全部索引
        IndicesResponse indicesResponse = elasticsearchClient.cat().indices();
        // 返回对象具体查看 co.elastic.clients.elasticsearch.cat.indices.IndicesRecord
        indicesResponse.valueBody().forEach(
                info -> log.info("health:{}\n status:{} \n uuid:{} \n ", info.health(), info.status(), info.uuid())
        );
    }

    /**
     * 添加一个文档
     *
     * @throws IOException ioexception
     * @see: https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/8.3/indexing.html#indexing
     */
    @Test
    void addOneDocument() throws IOException {
        ReviewEntity review = new ReviewEntity(new ReviewId(1L, 1L), "评论测试", Instant.now().toEpochMilli(), Instant.now().toEpochMilli());
        IndexResponse indexResponse = elasticsearchClient.index(s ->
                // 索引
                s.index("reviews")
                        // ID
                        .id(review.getReviewId().getReviewId().toString())
                        // 文档
                        .document(review)
        );
        log.info("result:{}", indexResponse.result().jsonValue());

    }

    /**
     * 获取文档
     * https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/8.3/reading.html#reading
     *
     * @throws IOException ioexception
     */
    @Test
    void getDocument() throws IOException {
        // co.elastic.clients.elasticsearch.core.get.GetResult<TDocument>
        GetResponse<ReviewEntity> getResponse = elasticsearchClient.get(s -> s.index("reviews")
                .id("1"), ReviewEntity.class);
        assert getResponse.source() != null;
        log.info("getResponse:{}", getResponse.source());

        // Reading a domain object
        if (getResponse.found()) {
            ReviewEntity product = getResponse.source();
            assert product != null;
            log.info("products{}", product);
        }

        // Reading raw JSON
        // if (getResponse.found())
        // {
        //    ObjectNode json = getResponse.source();
        //    String name = json.get("name").asText();
        //    log.info("Product name " + name);
        // }

        // 判断文档是否存在
        BooleanResponse booleanResponse = elasticsearchClient.exists(s -> s.index("reviews").id("1"));
        log.info("判断Document是否存在:{}", booleanResponse.value());
    }

}
