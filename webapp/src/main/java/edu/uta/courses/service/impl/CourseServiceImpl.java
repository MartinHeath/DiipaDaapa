/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.service.impl;

import edu.uta.courses.converter.CourseConverter;
import edu.uta.courses.repository.CourseRepository;
import edu.uta.courses.repository.domain.Course;
import edu.uta.courses.repository.domain.CourseUi;
import edu.uta.courses.service.CourseService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martin
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseRepository courseRepository;
    
    CourseConverter courseConverter = new CourseConverter();

    @Override
    public String getContent() {
        return "Here are your options: \n";
    }

    @Override
    public List<CourseUi> list() {
        List<Course> list = courseRepository.list();
        
        List<CourseUi> uiList = new ArrayList<CourseUi>();
        
        for(int i=0; i<list.size(); i++ ){
            Course c = list.get(i);
            CourseUi cui = new CourseUi();
            cui = courseConverter.convertDataToUi(cui,c);
            uiList.add(cui);
        } 
        return uiList;
    }

    @Override
    public void create(Course c) {
        courseRepository.create(c);

    }

    @Override
    public void delete(CourseUi c) {
        Course cdata = courseRepository.getCourseById(c.getCourseId());
        courseRepository.delete(cdata);
    }

    @Override
    public CourseUi getCourseById(Long id) {
        Course c = courseRepository.getCourseById(id);
        CourseUi cui = new CourseUi();
        cui = courseConverter.convertDataToUi(cui,c);
        return cui;
    }

    @Override
    public void update(CourseUi c) {
        Course datac = new Course();
        datac = courseConverter.convertUiToData(datac,c);
        courseRepository.update(datac);
    }
    
    
    
}
