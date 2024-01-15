package com.repoviewer.rest;

import com.repoviewer.config.ApiConfigProperties;
import com.repoviewer.domain.dto.WeeklyCommitResponseDto;
import com.repoviewer.domain.validation.ApiRequestValidator;
import com.repoviewer.domain.validation.ApiValidationErrorBuilder;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
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

    @GetMapping(path = "/dailyCommit/{owner}/{repo}")
    public ResponseEntity<?> getWeeklyCommit( @PathVariable("owner") String owner,
                                             @PathVariable("repo") String repo)
    {
        LOGGER.info(apiConfigProperties.getGitToken());

        if(ApiValidationErrorBuilder.wrongInputParameters(owner,repo))
        {
            return ResponseEntity.badRequest().body(ApiValidationErrorBuilder.fromStringErrors(List.of("Invalid Owner/Repo Name Format.")));
        }

        RequestEntity<?> getWeekCommitRequest = RequestEntity.get(apiConfigProperties.getWeeklyCommitUrl(),  owner, repo).
                header("Accept",apiConfigProperties.getAcceptMediaType()).
                header("Authorization", "Bearer "+apiConfigProperties.getGitToken()).
                header(apiConfigProperties.getAcceptVersion()).
                build();

       ResponseEntity<WeeklyCommitResponseDto> weeklyCommitResponseEntity = restTemplate.exchange(URI.create(apiConfigProperties.getWeeklyCommitUrl()),
                HttpMethod.GET,
                getWeekCommitRequest,
                WeeklyCommitResponseDto.class);
        LOGGER.info("Status Code: "+weeklyCommitResponseEntity.getStatusCode());
        return ResponseEntity.status(weeklyCommitResponseEntity.getStatusCode()).build();
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
