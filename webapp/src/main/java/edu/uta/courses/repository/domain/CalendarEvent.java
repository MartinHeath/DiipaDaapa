/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.repository.domain;

import java.util.Date;

/**
 *
 * @author Martin
 */
public class CalendarEvent {
    Long id;
    String title;
    Date start;
    Date end;
    
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle (){
        return title;
    }
    public void SetStart(Date strt){
        this.start = strt;
    }
    public Date getStart(){
        return this.start;
    }
    public void SetEnd(Date end){
        this.end = end;
    }
    public Date getEnd(){
        return this.end;
    }
}
