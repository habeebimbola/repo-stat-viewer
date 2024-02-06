package com.repoviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@JsonSerialize
public class HourlyCommitDto {

    @JsonProperty("hourlyCommits")
    private List<HourlyCommits> hourlyCommits;
    public HourlyCommitDto(List<List<Integer>> hourlyCommits) {
        this.makeHourlyCommits(hourlyCommits);
    }

    public List<HourlyCommits> getHourlyCommits() {
        return hourlyCommits;
    }

    private void makeHourlyCommits(List<List<Integer>> intList)
    {

        List<HourlyCommits> hourlyCommitsList= intList.stream().map( (list ) ->{
            HourlyCommits hourlyCommits = new HourlyCommits();
            list.forEach((data)->{
                hourlyCommits.setDayOfWeek(data);
//                hourlyCommits.setLocalTime(data);
                hourlyCommits.setCommitTotal(data);
            });
            return hourlyCommits;
        }).toList();

        this.setHourlyCommits(hourlyCommitsList);
    }

    public void setHourlyCommits(List<HourlyCommits> hourlyCommits) {
        this.hourlyCommits = hourlyCommits;
    }

}
