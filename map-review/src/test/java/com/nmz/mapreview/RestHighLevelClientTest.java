package com.nmz.mapreview;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/5-9:40
 */
@SpringBootTest
public class RestHighLevelClientTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void createIndices() throws IOException {
        // 1.创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("ljx666");
        // 2.客户端执行请求IndicesClient，执行create方法创建索引，请求后获得响应
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);

    }

    @Test
    void selectIndices() throws IOException {
        GetIndexRequest request = new GetIndexRequest("ljx666");
        restHighLevelClient.indices().get(request, RequestOptions.DEFAULT);
    }
}

