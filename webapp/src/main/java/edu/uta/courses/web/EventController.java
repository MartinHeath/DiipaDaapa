/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.web;

import edu.uta.courses.repository.domain.CalendarEvent;
import edu.uta.courses.repository.domain.EventUi;
import edu.uta.courses.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Martin
 */
@Controller
@RequestMapping(value= "/events")
public class EventController {
    
    @Autowired
    EventService eventService;
    
    @RequestMapping(value = "/home")
    public String eventCalendar(){
        return"/events/home";
    }
    
    @RequestMapping(value="/show")
    @ResponseBody
    public EventUi eventShow(@RequestParam("id") Long id){
        return eventService.getEventById(id);
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String eventCreate(@ModelAttribute("form") EventCreateForm form, Model model){
        return("/events/create");
    }
    
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String editPersonCommit( @Validated @ModelAttribute("form") EventCreateForm form, Model model) {
        EventUi event = new EventUi();
        
        event.setId(form.getId());
        event.setEventName(form.getEventName());
        event.setEventDescription(form.getEventDescription());
        event.setEventSystem(form.getSystem());
        String dateString = form.getStartDate() + " " + form.getStartTime();
        event.setStartTime(eventService.convertToDateTime(dateString));
        dateString = form.getEndDate() + " " + form.getEndTime();
        event.setEndTime(eventService.convertToDateTime(dateString));
        
        eventService.create(event);
        model.addAttribute("currentEvent", event);
        return "redirect:/events/home";
    }
    
    @RequestMapping(value={"/list"})
    @ResponseBody
    public List<CalendarEvent> listCalendarEvents (){
        return eventService.getCalendarEvents();
    }
    @RequestMapping(value={"/full-list"})
    @ResponseBody
    public List<EventUi> FullList (){
        return eventService.list();
    }
    
    @RequestMapping(value={"/delete"})
    public String deleteEvent ( @RequestParam("id") Long id, Model model){
        EventUi event = eventService.getEventById(id);
        eventService.delete(event);
        model.addAttribute("events", eventService.list());
        return "redirect:/events/home";
    }
    
    @RequestMapping(value="/update", method = RequestMethod.GET)
    public String updateEventOpen(@RequestParam("id") Long id, @ModelAttribute("form") EventCreateForm form, Model model) {
        EventUi event = eventService.getEventById(id);
        
        form.setEventName(event.getEventName());
        form.setEventDescription(event.getEventDescription());
        form.setSystem(event.getEventSystem());
        String[] dateParts  = eventService.convertDateToString(event.getStartTime());
        form.setStartDate(dateParts[0] + "." + dateParts[1] + "." + dateParts[2]);
        form.setStartTime(dateParts[3] + ":" + dateParts[4]);
        dateParts = eventService.convertDateToString(event.getEndTime());
        form.setEndDate(dateParts[0] + "." + dateParts[1] + "." + dateParts[2]);
        form.setEndTime(dateParts[3] + ":" + dateParts[4]);
        
        model.addAttribute("id", event.getId());
        return "/events/update";
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String UpdateeventCommit(@ModelAttribute("form") EventCreateForm form, Model model) {
        EventUi oldEvent = eventService.getEventById(form.getId());
        EventUi newEvent = new EventUi();
        newEvent.setId(oldEvent.getId());
        newEvent.setEventName(form.getEventName());
        newEvent.setEventDescription(form.getEventDescription());
        newEvent.setEventSystem(oldEvent.getEventSystem());
        newEvent.setStartTime(oldEvent.getStartTime());
        newEvent.setEndTime(oldEvent.getEndTime());
        newEvent.setCreatedOn(oldEvent.getCreatedOn());
        
        eventService.update(newEvent);
        return "redirect:/events/home";
    }
}
