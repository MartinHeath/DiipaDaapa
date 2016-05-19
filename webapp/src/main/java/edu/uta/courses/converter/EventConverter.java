/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.converter;

import edu.uta.courses.repository.domain.Event;
import edu.uta.courses.repository.domain.EventUi;

/**
 *
 * @author Martin
 */
public class EventConverter {
    
    public Event uiToData (EventUi eui, Event e){
        e.setId(eui.getId());
        e.setEventName(eui.getEventName());
        e.setEventDescription(eui.getEventDescription());
        e.setEventSystem(eui.getEventSystem());
        e.setStartTime(eui.getStartTime());
        e.setEndTime(eui.getEndTime());
        e.setCreatedOn(eui.getCreatedOn());
        e.setModifiedOn(eui.getModifiedOn());
        
        return e;
    }
    
    public EventUi dataToUi (Event e, EventUi eui){
        eui.setId(e.getId());
        eui.setEventName(e.getEventName());
        eui.setEventDescription(e.getEventDescription());
        eui.setEventSystem(e.getEventSystem());
        eui.setStartTime(e.getStartTime());
        eui.setEndTime(e.getEndTime());
        eui.setCreatedOn(e.getCreatedOn());
        eui.setModifiedOn(e.getModifiedOn());
        
        return eui;
    }
}
