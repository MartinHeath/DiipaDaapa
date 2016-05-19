/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.repository;

import edu.uta.courses.repository.domain.Course;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Martin
 */
@Transactional
public interface CourseRepository {
    public List<Course> list();
    
    public void create (Course c);
    
    public void delete (Course c);
    
    public void update (Course c);
    
    public Course getCourseById(Long id);
}
