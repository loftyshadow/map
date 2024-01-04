package com.nmz.mapreview.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/4-10:40
 */
@Configuration
public class ElasticSearchClientConfig{


    @Value("${spring.elasticsearch.uris}")
    private String hostname;

    /**
     * 获取elasticsearch客户端
     * @return {@link ElasticsearchClient}
     */
    @Bean
    public ElasticsearchClient getElasticsearchClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost(hostname.replace(":9200", "").replace("http://", "")
                        , 9200
                        , "http")).build();
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }
}