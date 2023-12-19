package com.repoviewer.rest;

import com.repoviewer.config.ApiConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/repo-stat")
public class GitRepoDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitRepoDataController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiConfigProperties apiConfigProperties;

    private final Pattern githubMetadataValidator = Pattern.compile("([A-Za-z]+\\-?[A-Za-z]+)+");

    @GetMapping(path = "/dailyCommit/{owner}/{repo}")
    public ResponseEntity<?> getWeeklyCommit(@PathVariable("owner") String owner,  @PathVariable("repo") String repo)
    {
        LOGGER.info(apiConfigProperties.getGitToken());

        if(!githubMetadataValidator.matcher(owner).matches() || !githubMetadataValidator.matcher(repo).matches())
        {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/lastYear/{owner}/{repo}")
    public ResponseEntity<?> getLastYearCommit( @PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/allContributor/{owner}/{repo}")
    public ResponseEntity<?> getAllContributor(@PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName)
    {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/weeklyCommitParticipation/{owner}/{repo}")
    public ResponseEntity<?> getWeeklyCommitParticipation(@PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName)
    {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/hourlyCommit/{owner}/{repo}")
    public ResponseEntity<?> getHourlyCommit(@PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
