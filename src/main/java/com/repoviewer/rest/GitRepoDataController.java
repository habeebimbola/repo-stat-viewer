package com.repoviewer.rest;

import com.repoviewer.domain.validation.ApiValidationErrorBuilder;
import com.repoviewer.github.client.error.GitHubClientError;
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


//        RequestEntity<?> getWeekCommitRequest = RequestEntity.get(apiConfigProperties.getWeeklyCommitUrl(),  owner, repo).
//                header("Accept",apiConfigProperties.getAcceptMediaType()).
//                header("Authorization", "Bearer "+apiConfigProperties.getGitToken()).
//                header(apiConfigProperties.getAcceptVersion()).
//                build();
//
//        Map<String, String> requestParametersMap = new HashMap<>();
//        requestParametersMap.put("owner", owner);
//        requestParametersMap.put("repo", repo);
//
//       ResponseEntity<List<List<Integer>>> weeklyCommitResponseEntity = restTemplate.exchange(apiConfigProperties.getWeeklyCommitUrl(),
//               HttpMethod.GET,
//               getWeekCommitRequest,
//               new ParameterizedTypeReference<>() {
//               },
//               requestParametersMap);
//
//        HttpStatusCode statusCode = weeklyCommitResponseEntity.getStatusCode();
//
//        if(statusCode == HttpStatus.ACCEPTED)
//        {
//            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//        }
//        if (weeklyCommitResponseEntity.getStatusCode() == HttpStatus.OK)
//        {
//
//            Objects.requireNonNull(weeklyCommitResponseEntity.getBody()).forEach((weeklyCommitResponseDto -> {
//                weeklyCommitResponseDto.forEach((weeklyCommitEntry -> { LOGGER.info(" "+weeklyCommitEntry);}));
//            }));
//
//            return ResponseEntity.status(statusCode).body( new WeeklyCommitResponseDto( weeklyCommitResponseEntity.getBody()));
//        }
//
//
//        return ResponseEntity.status(weeklyCommitResponseEntity.getStatusCode()).build();
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
