package com.nitesh.elk.config;

import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.nitesh.elk.repo")
public class ElasticDBConfig {
	
	@Value("${elastic.host}")
    private String hostName;

    @Value("${elastic.port}")
    private int esPort;

    @Value("${elastic.cluster.name}")
    private String clusterName;

    @Bean
    public Client client() throws Exception {
    	

        Settings esSettings = Settings.builder()
                .put("cluster.name", clusterName)
                .build();
        
        TransportClient client = new PreBuiltTransportClient(esSettings);
        client.addTransportAddress(
        		new TransportAddress(new InetSocketAddress(hostName, esPort)));
        return client;

    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }


}
