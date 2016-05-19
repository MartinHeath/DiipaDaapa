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
public class CourseUi {
    private Long courseId;
    private String courseName;
    private String courseDesc;
    private DateTime createdOn;
    private DateTime modifiedOn;
    
    public CourseUi(){
        this.createdOn = new DateTime();
    }
    
     public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long id) {
        this.courseId = id;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String Name) {
        this.courseName = Name;
    }
    public String getCourseDescription() {
        return this.courseDesc;
    }

    public void setCourseDescription(String description) {
        this.courseDesc = description;
    }
    
    public void setCreatedOn( DateTime tod){
        this.createdOn = tod;
    }
    
    public DateTime getCreatedOn(){
        return this.createdOn;
    }
    
    public void setModifiedOn( DateTime tod){
        this.modifiedOn = tod;
    }
    
    public DateTime getModifiedOn(){
        return this.modifiedOn;
    }
}
