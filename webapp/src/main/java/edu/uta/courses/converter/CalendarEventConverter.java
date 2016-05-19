/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.converter;

import edu.uta.courses.repository.domain.CalendarEvent;
import edu.uta.courses.repository.domain.EventUi;

/**
 *
 * @author Martin
 */
public class CalendarEventConverter {
    
    public CalendarEvent uiToCalendar (EventUi eui, CalendarEvent cal){
        
        cal.setId(eui.getId());
        cal.setTitle(eui.getEventName());
        cal.SetStart(eui.getStartTime().toDate());
        cal.SetEnd(eui.getEndTime().toDate());
        
        return cal;
    }
}
