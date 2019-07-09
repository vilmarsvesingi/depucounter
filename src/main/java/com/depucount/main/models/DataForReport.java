/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main.models;

/**
 *
 * @author vilmars.vesingi
 */
public class DataForReport {

    public static String getWorkTitle() {
        return workTitle;
    }

    public static void setWorkTitle(String workTitle) {
        DataForReport.workTitle = workTitle;
    }

    public static Integer getStartDay() {
        return startDay;
    }

    public static void setStartDay(Integer startDay) {
        DataForReport.startDay = startDay;
    }

    public static Double getUpperRoundWorkDuration() {
        return upperRoundWorkDuration;
    }

    public static void setUpperRoundWorkDuration(Double upperRoundWorkDuration) {
        DataForReport.upperRoundWorkDuration = upperRoundWorkDuration;
    }

    public static String getStartMonthText() {
        return startMonthText;
    }

    public static void setStartMonthText(String startMonthText) {
        DataForReport.startMonthText = startMonthText;
    }

    public static Integer getStartYear() {
        return startYear;
    }

    public static void setStartYear(Integer startYear) {
        DataForReport.startYear = startYear;
    }

    
    
    public static String workTitle;
    public static Integer startDay;
    public static String startMonthText;
    public static Integer startYear;
    public static Double upperRoundWorkDuration;

}
