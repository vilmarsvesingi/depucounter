/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main.models;

import java.text.DateFormatSymbols;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import com.depucount.main.utils.Converters;

/**
 *
 * @author vilmars.vesingi
 */
public class BasicWorkEntry {

    private String id;
    private String workName;
    private String workDetails;
    private String startTime;
    private String endTime;

    private Duration fromTimeWorkDuration;
    private Double upperRoundWorkDuration;
    private Double actualRoundWorkDuration;
    private Integer startDay;
    private Integer startMonth;
    private Integer startYear;
    private String startMonthText;
    private Long epochStartTime;

    public BasicWorkEntry(String id,
            String workName, String workDetails, String startTime, String endTime) {
        this.id = id;
        this.workName = workName;
        this.workDetails = workDetails;
        this.startTime = startTime;
        this.endTime = endTime;

        this.startDay = Converters.StringToLocalDateTime(startTime).getDayOfMonth();
        this.startMonth = Converters.StringToLocalDateTime(startTime).getMonthValue();
        this.startYear = Converters.StringToLocalDateTime(startTime).getYear();

        this.fromTimeWorkDuration = Duration.between(
                Converters.StringToLocalDateTime(startTime),
                Converters.StringToLocalDateTime(endTime));

        this.upperRoundWorkDuration = Converters.UpperRounder(fromTimeWorkDuration);
        this.actualRoundWorkDuration = (double) Math.round((double) fromTimeWorkDuration.toMinutes() / 60);
        this.startMonthText = Converters.MonthIntToMonthString(startMonth);
        this.epochStartTime = Converters.StringToLocalDateTime(startTime).atZone(ZoneId.systemDefault()).toEpochSecond();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Duration getFromTimeWorkDuration() {
        return fromTimeWorkDuration;
    }

    public void setFromTimeWorkDuration(Duration fromTimeWorkDuration) {
        this.fromTimeWorkDuration = fromTimeWorkDuration;
    }

    public Double getUpperRoundWorkDuration() {
        return upperRoundWorkDuration;
    }

    public void setUpperRoundWorkDuration(Double upperRoundWorkDuration) {
        this.upperRoundWorkDuration = upperRoundWorkDuration;
    }

    public Double getActualRoundWorkDuration() {
        return actualRoundWorkDuration;
    }

    public void setActualRoundWorkDuration(Double actualRoundWorkDuration) {
        this.actualRoundWorkDuration = actualRoundWorkDuration;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public String getWorkDetails() {
        return workDetails;
    }

    public Long getEpochStartTime() {
        return epochStartTime;
    }

    public void setEpochStartTime(Long epochStartTime) {
        this.epochStartTime = epochStartTime;
    }

    
    
    public void setWorkDetails(String workDetails) {
        this.workDetails = workDetails;
    }

    public String getStartMonthText() {
        return startMonthText;
    }

    public void setStartMonthText(String startMonthText) {
        this.startMonthText = startMonthText;
    }


}
