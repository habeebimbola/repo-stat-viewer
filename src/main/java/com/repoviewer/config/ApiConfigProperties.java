package com.repoviewer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:github.properties")
@ConfigurationProperties(prefix = "github")
public class ApiConfigProperties {

    @Value("${weekly-commit-url}")
    private String weeklyCommitUrl;

    @Value("${last-year-commit-url}")
    private String lastYearCommitUrl;

    @Value("${all-contributor-commit-url}")
    private String allContributorCommitUrl;

    @Value("${weekly-commit-participation-url}")
    private String weeklyParticipationUrl;

    @Value("${hourly-commit-url}")
    private String hourlyCommitUrl;

    public String getWeeklyCommitUrl() {
        return weeklyCommitUrl;
    }

    public String getLastYearCommitUrl() {
        return lastYearCommitUrl;
    }

    public String getAllContributorCommitUrl() {
        return allContributorCommitUrl;
    }

    public String getWeeklyParticipationUrl() {
        return weeklyParticipationUrl;
    }

    public String getHourlyCommitUrl() {
        return hourlyCommitUrl;
    }
}
