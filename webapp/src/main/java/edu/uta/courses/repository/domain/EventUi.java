/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.repository.domain;

import org.joda.time.DateTime;

/**
 *
 * @author Martin
 */
public class EventUi {
    private Long id;
    private String eventName;
    private String courseDescription;
    private String eventSystem;
    private DateTime startTime;
    private DateTime endTime;
    private DateTime createdOn;
    private DateTime modifiedOn;
    
    //Setters and Getters
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public void setEventName(String name){
        this.eventName = name;
    }
    public String getEventName(){
        return this.eventName;
    }
    
    public void setEventDescription(String desc){
        this.courseDescription = desc;
    }
    public String getEventDescription(){
        return this.courseDescription;
    }
    
    public void setEventSystem(String syst){
        this.eventSystem = syst;
    }
    public String getEventSystem(){
        return this.eventSystem;
    }
    
    public void setStartTime(DateTime start){
        this.startTime = start;
    }
    public DateTime getStartTime(){
        return this.startTime;
    }
    
    public void setEndTime(DateTime end){
        this.endTime = end;
    }
    public DateTime getEndTime(){
        return this.endTime;
    }
    
    public void setCreatedOn(DateTime dot){
        this.createdOn = dot;
    }
    public DateTime getCreatedOn(){
        return this.createdOn;
    }
    public void setModifiedOn(DateTime dot){
        this.modifiedOn = dot;
    }
    public DateTime getModifiedOn(){
        return this.modifiedOn;
    }
}
