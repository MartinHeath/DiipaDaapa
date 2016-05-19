/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.repository.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 *
 * @author Martin
 * The Data entity for game events
 */
@Entity
@Table(name="events")
public class Event implements Serializable{
    @Id
    @GeneratedValue
    @Column
    private Long id;
    
    @Column(nullable = false, length=50, updatable=true)
    private String eventName;
    
    @Column(nullable = false, length=100, updatable=true)
    private String courseDescription;
    
    @Column(nullable = false, length=30)
    private String eventSystem;
    
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startTime;
    
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endTime;
    
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdOn;
    
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
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