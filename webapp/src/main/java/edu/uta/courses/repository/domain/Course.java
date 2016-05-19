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
 */
@Entity
@Table(name = "courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private Long courseId;

    @Column(nullable = false, length =30, updatable=true)
    private String courseName;

    @Column(nullable = false)
    private String courseDescription;
    
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdOn;
    
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modifiedOn;
    
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
        return this.courseDescription;
    }

    public void setCourseDescription(String description) {
        this.courseDescription = description;
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
