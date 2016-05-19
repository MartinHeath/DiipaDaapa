package edu.uta.courses.repository.impl;

import edu.uta.courses.repository.CourseRepository;
import edu.uta.courses.repository.domain.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
@Repository("courseRepository")
public class CourseRepositoryImpl implements CourseRepository{

    @PersistenceContext(name = "entityManager")
    EntityManager em;
    
    @Override
    public List<Course> list() {
         return em.createQuery("SELECT z FROM Course z", Course.class).getResultList();
    }

    @Override
    public void create(Course c) {
        c.setCreatedOn(new DateTime());
        em.persist(c);
    }

    @Override
    public void delete(Course c) {
        Course course = getCourseById(c.getCourseId());
        em.remove(course);
        c.setCourseId(null);
    }

    @Override
    public Course getCourseById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public void update(Course c) {
        c.setModifiedOn(new DateTime());
        em.merge(c);
    }
    
}
