/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.converter;

import edu.uta.courses.repository.domain.Course;
import edu.uta.courses.repository.domain.CourseUi;

/**
 *
 * @author Martin
 */
public class CourseConverter {
    
    public CourseUi convertDataToUi (CourseUi cui, Course c){
        
        cui.setCourseId(c.getCourseId());
        
        cui.setCourseName(c.getCourseName());
        cui.setCourseDescription(c.getCourseDescription());
        
        cui.setCreatedOn(c.getCreatedOn());
        cui.setModifiedOn(c.getModifiedOn());
        return cui;
    }
    
    public Course convertUiToData(Course c, CourseUi cui){
        
        c.setCourseId(cui.getCourseId());
        
        c.setCourseName(cui.getCourseName());
        c.setCourseDescription(cui.getCourseDescription());
        
        c.setCreatedOn(cui.getCreatedOn());
        c.setModifiedOn(cui.getModifiedOn());
        return c;
    }
}
