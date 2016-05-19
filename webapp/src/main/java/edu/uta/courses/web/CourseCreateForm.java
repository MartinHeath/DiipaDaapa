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
public class CourseCreateForm {
    
    @GeneratedValue
    private Long courseId;

    @NotEmpty
    private String courseName;

    @NotEmpty
    private String courseDescription;
    
    
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

}
