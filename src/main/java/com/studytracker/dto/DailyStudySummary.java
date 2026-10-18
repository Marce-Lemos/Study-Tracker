package com.studytracker.dto;

import java.time.LocalDate;


public class DailyStudySummary {

    private LocalDate date;
    private Long totalMinutes;
    private Integer sessions;

    public DailyStudySummary() {}

    public DailyStudySummary(LocalDate date, Long totalMinutes, Integer sessions) {
        this.date = date;
        this.totalMinutes = totalMinutes;
        this.sessions = sessions;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(Long totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public Integer getSessions() {
        return sessions;
    }

    public void setSessions(Integer sessions) {
        this.sessions = sessions;
    }
}
