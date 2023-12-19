package com.repoviewer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class RepoStatviewerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void weeklyCommitWeb_Spec()
	{
        String str = " Your name is ";
        assertEquals("Yournameis", str.replaceAll("\\s",""));
//		this.mockMvc.perform().andExpect(status())
	}
}
