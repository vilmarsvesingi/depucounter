/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main.models;

import java.util.ArrayList;

/**
 *
 * @author vilmars.vesingi
 */
public class ListFilterDetails {
    
    public String chosenYear;
    public String chosenMonth;
    public ArrayList<String> chosenTasks;

    public ListFilterDetails(String chosenYear, String chosenMonth, ArrayList<String> chosenTasks) {
        this.chosenYear = chosenYear;
        this.chosenMonth = chosenMonth;
        this.chosenTasks = chosenTasks;
    }

    
    
    public String getChosenYear() {
        return chosenYear;
    }

    public void setChosenYear(String chosenYear) {
        this.chosenYear = chosenYear;
    }

    public String getChosenMonth() {
        return chosenMonth;
    }

    public void setChosenMonth(String chosenMonth) {
        this.chosenMonth = chosenMonth;
    }

    public ArrayList<String> getChosenTasks() {
        return chosenTasks;
    }

    public void setChosenTasks(ArrayList<String> chosenTasks) {
        this.chosenTasks = chosenTasks;
    }
    
    
}
