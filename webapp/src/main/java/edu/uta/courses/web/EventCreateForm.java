/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.web;

import javax.persistence.GeneratedValue;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Martin
 */
public class EventCreateForm {
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String eventName;

    @NotEmpty
    private String eventDescription;
    
    @NotEmpty
    private String system;
    
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String endDate;
    @NotEmpty
    private String endTime;
    
    
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return this.eventName;
    }
    public void setEventName(String Name) {
        this.eventName = Name;
    }
    
    public String getEventDescription() {
        return this.eventDescription;
    }
    public void setEventDescription(String description) {
        this.eventDescription = description;
    }
    
    public void setSystem (String syst){
        this.system = syst;
    }
    
    public String getSystem(){
        return this.system;
    }
    
    public void setStartDate(String date){
        this.startDate = date;
    }
    public String getStartDate(){
        return this.startDate;
    }
    
    public void setEndDate(String date){
        this.endDate = date;
    }
    public String getEndDate(){
        return this.endDate;
    }
    
    public void setStartTime(String start){
        this.startTime = start;
    }
    public String getStartTime(){
        return this.startTime;
    }
    
    public void setEndTime(String end){
        this.endTime = end;
    }
    public String getEndTime(){
        return this.endTime;
    }
}
