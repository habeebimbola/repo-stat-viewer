package com.repoviewer;

import com.repoviewer.config.ApiConfigProperties;
import com.repoviewer.domain.dto.WeeklyCommitEntry;
import com.repoviewer.github.client.service.GithubIntegrationClient;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@RestClientTest({GithubIntegrationClient.class, ApiConfigProperties.class})
@AutoConfigureWebClient(registerRestTemplate = true)
class RepoStatviewerApplicationTests {

	@MockBean
	MockMvc mockMvc;

	@Autowired
	private ApiConfigProperties apiConfigProperties;
	@MockBean
	private GithubIntegrationClient githubIntegrationClient;

	@BeforeEach()
	void setup(){
		WeeklyCommitEntry weeklyCommitEntry = new WeeklyCommitEntry();weeklyCommitEntry.setWeekDate(LocalDateTime.now()); weeklyCommitEntry.setDeletions(100);
		weeklyCommitEntry.setWeekDate(LocalDateTime.now());weeklyCommitEntry.setAdditions(300);
		when(githubIntegrationClient.getWeeklyCommit("habeebimbola","directory-file-searcher")).thenReturn(List.of(weeklyCommitEntry));
	}

//	@Test
//	void weeklyCommitWeb_Spec() throws Exception {
//		mockMvc.perform(get("/api/dailyCommit/{owner}/{repo}", "habeeb", "directory-file-searcher").
//				contentType(MediaType.APPLICATION_JSON)).andExpect(status
//				().isOk()).andReturn();
//
//	}
}
