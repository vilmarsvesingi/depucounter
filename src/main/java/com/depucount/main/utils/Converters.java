/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main.utils;

import java.text.DateFormatSymbols;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author vilmars.vesingi
 */
public class Converters {
    
    
   public static String[] months = new DateFormatSymbols().getMonths();
    
   
   public static ArrayList<String> ConvertAndSortFromMonthIntToAString(ArrayList<Integer> incoming){
       
    Collections.sort(incoming);

      
        ArrayList<String> outgoing = new ArrayList();
        
        for (Integer monthInt : incoming) {

            if (!outgoing.contains(months[monthInt - 1])) {
                outgoing.add(
                        months[monthInt - 1].substring(0, 1).toUpperCase()
                        + months[monthInt - 1].substring(1).toLowerCase()
                );
            }
        }
        return outgoing;
   }

    public static String MonthIntToMonthString(Integer monthInt) {
        String[] monthsStrings = new DateFormatSymbols().getMonths();
        return monthsStrings[monthInt - 1].substring(0, 1).toUpperCase() + monthsStrings[monthInt - 1].substring(1).toLowerCase();
    }

    public static Double UpperRounder(Duration time) {
        Double upperRoundedTime;
        Double decimalHours = (double) time.toMinutes() / 60;
        Double decimalPointsOfHours = decimalHours - Math.floor(decimalHours);
        if (decimalHours >= 1) {
            if (decimalPointsOfHours <= 0.2) {
                upperRoundedTime = Math.floor(decimalHours);
            } else if (decimalPointsOfHours > 0.2 && decimalPointsOfHours < 0.6) {
                upperRoundedTime = 0.5 + Math.floor(decimalHours);
            } else {
                upperRoundedTime = Math.ceil(decimalHours);
            }
            return upperRoundedTime;
        } else {
            if (decimalPointsOfHours <= 0.5) {
                upperRoundedTime = 0.5;
            } else {
                upperRoundedTime = 1.0;
            }
            return upperRoundedTime;
        }
    }

    public static LocalDateTime StringToLocalDateTime(String stringTime) {
        return LocalDateTime.parse(stringTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static String MakeFirstCharToUpper(String x) {
        x = x.toLowerCase();
        return x.substring(0, 1).toUpperCase() + x.substring(1);
    }

    public static String AddZerosToTime(Integer time) {
        StringBuilder sb = new StringBuilder();
        if (time < 10) {
            sb.append(0).append(time);
        } else {
            sb.append(time);
        }
        return sb.toString();
    }

    public static Boolean PartOfDateIsValid(String input, int maxlenght) {
        if (input.contains("[a-zA-Z]+") || input.length() > maxlenght || input.isEmpty()) {
            return false;
        }
        return true;
    }

    public static Boolean CompareIfStartIsSmallerThanFinish(String startTime, String finishTime) {
        ZoneId zoneID = ZoneId.systemDefault();
        Long epochStart = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).atZone(zoneID).toEpochSecond();
        Long epochFinish = LocalDateTime.parse(finishTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).atZone(zoneID).toEpochSecond();
        return epochFinish > epochStart;
    }
}
