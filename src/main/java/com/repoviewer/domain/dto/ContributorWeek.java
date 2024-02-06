package com.repoviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
public class ContributorWeek {

    @JsonProperty("w")
    private Long week;

    @JsonProperty("a")
    private Integer aValue;

    @JsonProperty("d")
    private Integer day;

    @JsonProperty("c")
    private Integer cVal;

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public Integer getaValue() {
        return aValue;
    }

    public void setaValue(Integer aValue) {
        this.aValue = aValue;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getcVal() {
        return cVal;
    }

    public void setcVal(Integer cVal) {
        this.cVal = cVal;
    }
}
