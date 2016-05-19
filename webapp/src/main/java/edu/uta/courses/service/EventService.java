/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.service;

import edu.uta.courses.repository.domain.CalendarEvent;
import edu.uta.courses.repository.domain.EventUi;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Martin
 */
public interface EventService {
    
    public void create(EventUi e);
    
    public List<EventUi>  list();
    
    public void delete (EventUi eui);
    
    public EventUi getEventById(Long id);
    
    public void update(EventUi eui);
    
    public DateTime convertToDateTime(String time);
    
    public String[] convertDateToString (DateTime time);
    
    public List<CalendarEvent> getCalendarEvents ();
}
