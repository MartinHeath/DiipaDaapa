/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.service.impl;

import edu.uta.courses.converter.CalendarEventConverter;
import edu.uta.courses.converter.EventConverter;
import edu.uta.courses.repository.EventRepository;
import edu.uta.courses.repository.domain.CalendarEvent;
import edu.uta.courses.repository.domain.Event;
import edu.uta.courses.repository.domain.EventUi;
import edu.uta.courses.service.EventService;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martin
 */
@Service("EventService")
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepo;
    
    EventConverter eventConverter = new EventConverter();
    CalendarEventConverter calConvert = new CalendarEventConverter();
    
    @Override
    public void create(EventUi e) {
        Event data = new Event();
        //e.setId(data.getId());
        data =eventConverter.uiToData(e, data);
        eventRepo.create(data);
    }

    @Override
    public List<EventUi> list() {
        List<Event> list = eventRepo.list();
        
        List<EventUi> uiList= new ArrayList<EventUi>();
        
        for(int i= 0; i< list.size(); i++){
            Event e = list.get(i);
            EventUi eui = new EventUi();
            eui = eventConverter.dataToUi(e, eui);
            uiList.add(eui);
        }
        
        return uiList;
    }

    @Override
    public void delete(EventUi eui) {
        Event e = eventRepo.getEventById(eui.getId());
        eventRepo.delete(e);
    }

    @Override
    public EventUi getEventById(Long id) {
        Event e = eventRepo.getEventById(id);
        EventUi eui = new EventUi();
        eui = eventConverter.dataToUi(e, eui);
        return eui;
    }

    @Override
    public void update(EventUi eui) {
        Event e = new Event();
        e = eventConverter.uiToData(eui, e);
        eventRepo.update(e);
    }

    @Override
    public DateTime convertToDateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy kk:mm");
        DateTime dt = formatter.parseDateTime(time);
        
        return dt;
    }

    @Override
    public String[] convertDateToString(DateTime time) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd MM yyyy kk mm");
        String date = time.toString(formatter);
        String[] list = date.split(" ");
        
        return list;
    }

    @Override
    public List<CalendarEvent> getCalendarEvents() {
       List<EventUi> list = list();
       List<CalendarEvent> calList = new ArrayList<CalendarEvent>();
       for(int i= 0; i < list.size(); i++){
           CalendarEvent cal = new CalendarEvent();
           cal = calConvert.uiToCalendar(list.get(i), cal);
           calList.add(cal);
       }
       return calList;
    }
    
}
