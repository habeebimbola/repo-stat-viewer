package com.repoviewer.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize
public class WeeklyCommitResponseDto {

    public List<WeeklyCommitEntry> commitEntryList;

    public List<WeeklyCommitEntry> getCommitEntryList() {
        return commitEntryList;
    }

    public void setCommitEntryList(List<WeeklyCommitEntry> commitEntryList) {
        this.commitEntryList = commitEntryList;
    }
}
