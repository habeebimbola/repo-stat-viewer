package com.repoviewer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RepoAppConfiguration {

    @Autowired
    private ApiConfigProperties apiConfigProperties;

    @Bean
    public RestTemplate createRestTemplate()
    {
        RestTemplate restTemplate = new  RestTemplateBuilder().build();
        return restTemplate;
    }

}
