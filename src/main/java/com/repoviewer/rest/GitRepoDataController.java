package com.repoviewer.rest;

import com.repoviewer.config.ApiConfigProperties;
import com.repoviewer.domain.dto.ApiRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/repo-stat")
public class GitRepoDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitRepoDataController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiConfigProperties apiConfigProperties;

    @GetMapping(path = "/dailyCommit/{owner}/{repo}")
    public ResponseEntity<?> getWeeklyCommit(@PathVariable("owner") String owner, @PathVariable("repo") String repo)
    {
           LOGGER.info("Hiting the {0} endpoint", apiConfigProperties.getAllContributorCommitUrl());
          return ResponseEntity.status(HttpStatus.OK).build();
    }
}
