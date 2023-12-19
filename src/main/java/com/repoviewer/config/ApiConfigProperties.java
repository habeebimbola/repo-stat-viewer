package com.repoviewer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:github.properties")
@ConfigurationProperties("github")
public class ApiConfigProperties {

    private String weeklyCommitUrl;

    private String lastYearCommitUrl;

    private String allContributorCommitUrl;

    private String weeklyCommitParticipationUrl;

    private String hourlyCommitUrl;

    private String acceptVersion;

    private String acceptMediaType;

    private String gitToken;

    public String getWeeklyCommitUrl() {
        return weeklyCommitUrl;
    }

    public String getLastYearCommitUrl() {
        return lastYearCommitUrl;
    }

    public String getAllContributorCommitUrl() {
        return allContributorCommitUrl;
    }

    public String getWeeklyCommitParticipationUrl() {
        return weeklyCommitParticipationUrl;
    }

    public String getHourlyCommitUrl() {
        return hourlyCommitUrl;
    }

    public String getAcceptVersion() {
        return acceptVersion;
    }

    public String getAcceptMediaType() {
        return acceptMediaType;
    }

    public String getGitToken() {
        return gitToken;
    }

    public void setWeeklyCommitUrl(String weeklyCommitUrl) {
        this.weeklyCommitUrl = weeklyCommitUrl;
    }

    public void setLastYearCommitUrl(String lastYearCommitUrl) {
        this.lastYearCommitUrl = lastYearCommitUrl;
    }

    public void setAllContributorCommitUrl(String allContributorCommitUrl) {
        this.allContributorCommitUrl = allContributorCommitUrl;
    }

    public void setWeeklyCommitParticipationUrl(String weeklyCommitParticipationUrl) {
        this.weeklyCommitParticipationUrl = weeklyCommitParticipationUrl;
    }

    public void setHourlyCommitUrl(String hourlyCommitUrl) {
        this.hourlyCommitUrl = hourlyCommitUrl;
    }

    public void setAcceptVersion(String acceptVersion) {
        this.acceptVersion = acceptVersion;
    }

    public void setAcceptMediaType(String acceptMediaType) {
        this.acceptMediaType = acceptMediaType;
    }

    public void setGitToken(String gitToken) {
        this.gitToken = gitToken;
    }
}
