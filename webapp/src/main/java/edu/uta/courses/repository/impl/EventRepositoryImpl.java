/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.repository.impl;

import edu.uta.courses.repository.EventRepository;
import edu.uta.courses.repository.domain.Event;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martin
 */
@Repository("EventRepository")
public class EventRepositoryImpl implements EventRepository{

    @PersistenceContext(name = "entityManager")
    EntityManager em;
    
    @Override
    public void create(Event e) {
        e.setCreatedOn(new DateTime());
        em.persist(e);
    }

    @Override
    public List<Event> list() {
       return em.createQuery("SELECT z FROM Event z", Event.class).getResultList();
    }

    @Override
    public void delete(Event e) {
        Event ev = getEventById(e.getId());
        em.remove(ev);
        ev.setId(null);
    }

    @Override
    public Event getEventById(Long id) {
        return em.find(Event.class, id);
    }

    @Override
    public void update(Event e) {
        e.setModifiedOn(new DateTime());
        em.merge(e);
    }
    
}
