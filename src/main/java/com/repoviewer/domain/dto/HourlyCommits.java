package com.repoviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalTime;

@JsonSerialize
public class HourlyCommits {

    @JsonProperty("dayOfWeek")
    private Integer dayOfWeek;

    @JsonProperty("localTime")
    private LocalTime localTime;

    @JsonProperty("totalCommits")
    private Integer commitTotal;

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public Integer getCommitTotal() {
        return commitTotal;
    }

    public void setCommitTotal(Integer commitTotal) {
        this.commitTotal = commitTotal;
    }
}
