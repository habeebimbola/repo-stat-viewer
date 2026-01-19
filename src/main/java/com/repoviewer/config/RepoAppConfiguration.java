package com.repoviewer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;

@Configuration
public class RepoAppConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepoAppConfiguration.class);

    @Bean
    public RestTemplate createRestTemplate()
    {
        return new RestTemplateBuilder().errorHandler(responseErrorHandler()).build();
    }

    private ResponseErrorHandler responseErrorHandler(){
        return new DefaultResponseErrorHandler(){
            @Override
          public void handleError(ClientHttpResponse response) throws IOException {
                LOGGER.error(response.toString());
                LOGGER.error(StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
          }
        };

    }

}
