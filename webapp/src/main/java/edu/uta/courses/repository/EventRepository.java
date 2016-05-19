/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.repository;

import edu.uta.courses.repository.domain.Event;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Martin
 */
@Transactional
public interface EventRepository {
    
    public void create(Event e);
    public void delete(Event e);
    public void update (Event e);
    public Event getEventById(Long id);
    public List<Event> list();
       
}
