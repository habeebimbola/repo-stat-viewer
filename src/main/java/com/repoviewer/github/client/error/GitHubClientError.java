package com.repoviewer.github.client.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.Charset;

public class GitHubClientError extends DefaultResponseErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubClientError.class);

    @Override
    protected void handleError(ClientHttpResponse response, HttpStatusCode statusCode) throws IOException {
        LOGGER.error(response.toString());
        LOGGER.error(StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
    }
}
