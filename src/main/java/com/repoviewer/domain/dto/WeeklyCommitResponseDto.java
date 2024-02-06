package com.repoviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonDeserialize
public class WeeklyCommitResponseDto {

    private static Logger LOGGER = LoggerFactory.getLogger(WeeklyCommitResponseDto.class);
    @JsonIgnore
    private List<List<Integer>> weeklyCommitsList;

    @JsonProperty("weeklyCommits")
    private List<WeeklyCommitEntry> weeklyCommitEntries;
    public WeeklyCommitResponseDto(List<List<Integer>> commitsList) {
//        LocalDateTime.ofEpochSecond(1367712000,1367712000, ZoneOffset.UTC);
//        Instant.ofEpochSecond(1367712000).adjustInto(LocalDateTime.now());

        this.weeklyCommitsList = commitsList;
        this.weeklyCommitEntries = new ArrayList<>();
        this.createWeeklyCommitEntries();
    }

    public List<WeeklyCommitEntry> getWeeklyCommitEntries() {
        return weeklyCommitEntries;
    }

    private void createWeeklyCommitEntries( )
    {
            weeklyCommitEntries = this.weeklyCommitsList.stream().map((integerList)->{
            WeeklyCommitEntry weeklyCommitEntry = new WeeklyCommitEntry();
            integerList.stream().forEach((integer -> {
                LOGGER.info(""+integer+" " + integer+" "+integer);
//                weeklyCommitEntry.setWeekDate(LocalDateTime.ofInstant(Instant.ofEpochSecond( integer), ZoneId.systemDefault()));
//                weeklyCommitEntry.setAdditions(integer);
//                weeklyCommitEntry.setDeletions(integer);
            }));
//            weeklyCommitEntry.setWeekDate( LocalDateTime.ofInstant(Instant.ofEpochSecond( integerList.stream().findFirst().get()), ZoneId.systemDefault()));
           return weeklyCommitEntry;
        }).collect(Collectors.toList());
    }

    public List<List<Integer>> getWeeklyCommitsList() {
        return weeklyCommitsList;
    }
}
