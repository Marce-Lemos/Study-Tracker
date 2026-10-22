package com.studytracker.dto;

import java.time.LocalDate;

public class WeeklyStudySummary {

    private LocalDate startDate;
    private LocalDate endDate;
    private Long totalMinutes;
    private Integer totalSessions;

    public WeeklyStudySummary(LocalDate startDate, LocalDate endDate, Long totalMinutes, Integer totalSessions) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalMinutes = totalMinutes;
        this.totalSessions = totalSessions;
    }

    public WeeklyStudySummary() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(Long totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public Integer getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(Integer totalSessions) {
        this.totalSessions = totalSessions;
    }
}
