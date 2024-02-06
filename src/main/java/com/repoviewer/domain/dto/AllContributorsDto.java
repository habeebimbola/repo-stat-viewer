package com.repoviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public class AllContributorsDto {

    @JsonProperty("author")
    private ContributorAuthor contributorAuthor;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("weeks")
    private List<ContributorWeek> contributorWeekList;

    public ContributorAuthor getContributorAuthor() {
        return contributorAuthor;
    }

    public void setContributorAuthor(ContributorAuthor contributorAuthor) {
        this.contributorAuthor = contributorAuthor;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ContributorWeek> getContributorWeekList() {
        return contributorWeekList;
    }

    public void setContributorWeekList(List<ContributorWeek> contributorWeekList) {
        this.contributorWeekList = contributorWeekList;
    }
}
