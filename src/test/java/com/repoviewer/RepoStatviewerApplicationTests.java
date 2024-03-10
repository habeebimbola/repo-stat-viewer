package com.repoviewer;

import com.repoviewer.config.ApiConfigProperties;
import com.repoviewer.github.client.service.GithubClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestClientTest({GithubClient.class, ApiConfigProperties.class})
@AutoConfigureWebClient(registerRestTemplate = true)
class RepoStatviewerApplicationTests {

	@Autowired
	private GithubClient githubClient;

	@Test
	void weeklyCommitWeb_Spec() throws Exception {
//		githubClient.getWeeklyCommit("habeebimbola","directory-file-searcher");
	}
}
