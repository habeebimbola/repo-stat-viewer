package com.repoviewer.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonDeserialize
public class WeeklyCommitEntry {

    private List<Integer> entries;

    public List<Integer> getEntries() {
        return entries;
    }

    public void setEntries(List<Integer> entries) {
        this.entries = entries;
    }
}
