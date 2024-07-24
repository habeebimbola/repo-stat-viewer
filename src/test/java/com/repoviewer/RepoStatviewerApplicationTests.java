package com.repoviewer;

import com.repoviewer.config.ApiConfigProperties;
import com.repoviewer.github.client.service.GithubIntegrationClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RestClientTest({GithubIntegrationClient.class, ApiConfigProperties.class})
@AutoConfigureWebClient(registerRestTemplate = true)
class RepoStatviewerApplicationTests {

	static final Logger LOGGER  = LoggerFactory.getLogger(GithubIntegrationClient.class);


	@Autowired
	private ApiConfigProperties apiConfigProperties;
	@MockBean
	private GithubIntegrationClient githubIntegrationClient;

	@Test
	void weeklyCommitWeb_Spec() throws Exception {
		when(githubIntegrationClient.getWeeklyCommit("habeebimbola","directory-file-searcher")).thenReturn(null);
	}
}
