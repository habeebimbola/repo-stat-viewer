package com.repoviewer.rest;

import com.repoviewer.domain.validation.ApiValidationErrorBuilder;
import com.repoviewer.github.client.service.GithubClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GitRepoDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitRepoDataController.class);

    @Autowired
    private GithubClient githubClient;

    @GetMapping(path = "/dailyCommit/{owner}/{repo}")
    public ResponseEntity<?> getWeeklyCommit( @PathVariable("owner") String owner,
                                             @PathVariable("repo") String repo)
    {
        if(ApiValidationErrorBuilder.wrongInputParameters(owner,repo))
        {
            return ResponseEntity.badRequest().body(ApiValidationErrorBuilder.fromStringErrors(List.of("Invalid Owner/Repo Name Format.")));
        }

        return ResponseEntity.ok().body(githubClient.getWeeklyCommit(owner, repo));

    }

    @GetMapping("/lastYear/{owner}/{repo}")
    public ResponseEntity<?> getLastYearCommit( @PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName)
    {
        if(ApiValidationErrorBuilder.wrongInputParameters(repoOwner,repoName))
        {
            return ResponseEntity.badRequest().body(ApiValidationErrorBuilder.fromStringErrors(List.of("Invalid Owner/Repo Name Format.")));
        }

        return ResponseEntity.ok(this.githubClient.getLastYearCommit(repoOwner,repoName));

    }

    @GetMapping(path = "/contributors/{owner}/{repo}")
    public ResponseEntity<?> getAllContributors(@PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName)
    {
        if(ApiValidationErrorBuilder.wrongInputParameters(repoOwner,repoName))
        {
            return ResponseEntity.badRequest().body(ApiValidationErrorBuilder.fromStringErrors(List.of("Invalid Owner/Repo Name Format.")));
        }

        return ResponseEntity.status(HttpStatus.OK). body(githubClient.getAllContributors(repoOwner,repoName));
    }

    @GetMapping(path = "/weeklyParticipation/{owner}/{repo}")
    public ResponseEntity<?> getWeeklyCommitParticipation(@PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName)
    {
        if(ApiValidationErrorBuilder.wrongInputParameters(repoOwner,repoName))
        {
            return ResponseEntity.badRequest().body(ApiValidationErrorBuilder.fromStringErrors(List.of("Invalid Owner/Repo Name Format.")));
        }
        return ResponseEntity.status(HttpStatus.OK).body(githubClient.getWeeklyCommitParticipation(repoOwner,repoName)) ;
    }

    @GetMapping(path = "/hourlyCommit/{owner}/{repo}")
    public ResponseEntity<?> getHourlyCommit(@PathVariable("owner") String repoOwner, @PathVariable("repo") String repoName){
        if(ApiValidationErrorBuilder.wrongInputParameters(repoOwner,repoName))
        {
            return ResponseEntity.badRequest().body(ApiValidationErrorBuilder.fromStringErrors(List.of("Invalid Owner/Repo Name Format.")));
        }
        return ResponseEntity.status(HttpStatus.OK).body(githubClient.getHourlyCommits(repoOwner,repoName));
    }


}
