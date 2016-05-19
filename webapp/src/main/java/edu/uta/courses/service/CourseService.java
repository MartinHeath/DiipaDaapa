/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.service;

import edu.uta.courses.repository.domain.Course;
import edu.uta.courses.repository.domain.CourseUi;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface CourseService {
    
    public String getContent();
    
    public void create(Course c);
    
    public void delete(CourseUi c);
    
    public CourseUi getCourseById(Long id);
    
    public void update(CourseUi c);
    
    public List<CourseUi> list();
}
