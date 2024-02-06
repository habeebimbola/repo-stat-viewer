package com.repoviewer.github.client.service;

import com.repoviewer.config.ApiConfigProperties;
import com.repoviewer.domain.dto.*;
import com.repoviewer.github.client.error.GitHubClientError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GithubClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(GithubClient.class);
    private final RestTemplate restTemplate;
    private final ApiConfigProperties apiConfigProperties;


    public GithubClient(RestTemplate restTemplate, ApiConfigProperties apiConfigProperties) {
        this.restTemplate = restTemplate;
        this.apiConfigProperties = apiConfigProperties;
        this.restTemplate.setErrorHandler(new GitHubClientError());
    }

   public List<WeeklyCommitEntry> getWeeklyCommit(String owner, String repoName)
    {
        RequestEntity<?> requestEntity = RequestEntity.method(HttpMethod.GET,
                        apiConfigProperties.getWeeklyCommitUrl(),
                        owner, repoName).
                header("Accept",apiConfigProperties.getAcceptMediaType()).
                header(apiConfigProperties.getAcceptVersion()).
                header("Authorization","Bearer "+apiConfigProperties.getGitToken()).
                build();

        ResponseEntity<List< List<Integer>>> responseEntity = this.restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List< List<Integer>>>() {
        });
       HttpStatusCode statusCode = responseEntity.getStatusCode();

        if (statusCode == HttpStatus.OK)
        {
             return this.createWeeklyCommitEntries( responseEntity.getBody());
        }

        return List.of(new WeeklyCommitEntry());
    }

   public  List<LastYearCommitDto> getLastYearCommit(String owner, String repoName){

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("owner",owner);
        requestMap.put("repo", repoName);

        RequestEntity requestEntity = RequestEntity.method(HttpMethod.GET, apiConfigProperties.getLastYearCommitUrl(), requestMap).
                header("Accept",apiConfigProperties.getAcceptMediaType()).
                header(apiConfigProperties.getAcceptVersion()).
                header("Authorization", "Bearer"+ apiConfigProperties.getGitToken()).
                build();

        ResponseEntity<List<LastYearCommitDto>> responseEntity = this.restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<LastYearCommitDto>>() {
        });

        HttpStatusCode statusCode = responseEntity.getStatusCode();

        if (statusCode == HttpStatus.OK)
        {
            return responseEntity.getBody();
        }

        return List.of( new LastYearCommitDto());
    }

    public List<AllContributorsDto> getAllContributors(String owner, String repoName){

        RequestEntity requestEntity = RequestEntity.method(HttpMethod.GET, apiConfigProperties.getAllContributorCommitUrl(), owner, repoName).
                header("Accept", apiConfigProperties.getAcceptMediaType()).
                header(apiConfigProperties.getAcceptVersion()).
                header("Authorization", "Bearer"+apiConfigProperties.getGitToken()).
                build();

        ResponseEntity<List<AllContributorsDto>> responseEntity = this.restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<AllContributorsDto>>() {
        });

        HttpStatusCode statusCode = responseEntity.getStatusCode();

        if (statusCode == HttpStatus.OK)
        {
            return responseEntity.getBody();
        }

        if (statusCode == HttpStatus.ACCEPTED)
        {

        }


        return List.of(new AllContributorsDto());
    }
    public WeeklyCommitParticipationDto getWeeklyCommitParticipation(String owner, String repoName){

        RequestEntity requestEntity = RequestEntity.method(HttpMethod.GET, apiConfigProperties.getWeeklyCommitParticipationUrl(), owner, repoName).
                                        header(apiConfigProperties.getAcceptVersion()).
                header("Authorization","Bearer "+apiConfigProperties.getGitToken()).
                header("Accept", apiConfigProperties.getAcceptMediaType()).
                                        build();

        ResponseEntity<WeeklyCommitParticipationDto> responseEntity = this.restTemplate.exchange(requestEntity, new ParameterizedTypeReference<WeeklyCommitParticipationDto>() {
        });

        HttpStatusCode httpStatusCode = responseEntity.getStatusCode();

        if (httpStatusCode == HttpStatus.OK)
        {
            return responseEntity.getBody();
        }
        return new WeeklyCommitParticipationDto();
    }

    public List<HourlyCommits> getHourlyCommits(String owner, String repoName){

        RequestEntity<Void> requestEntity = RequestEntity.method(HttpMethod.GET, apiConfigProperties.getHourlyCommitUrl(), owner, repoName).
                header("Accept", apiConfigProperties.getAcceptMediaType()).
                header(apiConfigProperties.getAcceptVersion()).
                header("Authorization", "Bearer "+apiConfigProperties.getGitToken()).
                build();

        ResponseEntity<List<List<Integer>>> responseEntity= this.restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<List<Integer>>>() {
        });

        HttpStatusCode statusCode = responseEntity.getStatusCode();

        if (statusCode  == HttpStatus.OK)
        {

            return  this.makeHourlyCommitsList(responseEntity.getBody());

        }
        return List.of(new HourlyCommits());
    }

    private List<HourlyCommits> makeHourlyCommitsList(List<List<Integer>> commitsList)
    {
        commitsList.stream().map((list)->{
            HourlyCommits hourlyCommits = new HourlyCommits();
            hourlyCommits.setDayOfWeek( list.get(0));
            hourlyCommits.setLocalTime( LocalTime.of( list.get(1),0));
            hourlyCommits.setCommitTotal( list.get(2));
            return hourlyCommits;
        }).collect(Collectors.toList());

        return commitsList.stream().map( (list) ->{
            HourlyCommits hourlyCommits = new HourlyCommits();
            hourlyCommits.setDayOfWeek(list.get(0));
            hourlyCommits.setLocalTime(LocalTime.of( list.get(1),0));
            hourlyCommits.setCommitTotal(list.get(2));

            return hourlyCommits;
        }).toList();
    }

    private List<WeeklyCommitEntry> createWeeklyCommitEntries(List<List<Integer>> lists){

        return lists.stream().map((list) ->{
            WeeklyCommitEntry weeklyCommitEntry = new WeeklyCommitEntry();
            weeklyCommitEntry.setWeekDate(LocalDateTime.ofInstant(Instant.ofEpochSecond( list.get(0)), ZoneId.systemDefault()));
            weeklyCommitEntry.setDeletions(list.get(1));
            weeklyCommitEntry.setAdditions(list.get(2));
            return weeklyCommitEntry;
                }).
                toList();
    }

}
