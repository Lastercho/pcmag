package org.isbg.pcmag.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "http://localhost:9200/")
public class ElasticConfiguration {



}
