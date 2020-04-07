package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Events;

import java.util.List;

public interface EventsDAO {
    Events getEvent(Integer eventId) throws Exception;
    Integer addNewEvent(Events event) throws Exception;
    Events editEvent(Integer blogId, Events event) throws Exception;
    Integer deleteEvent(Integer blogId) throws Exception;
    List<Events> getPastEvents() throws Exception;
    List<Events> getAllEvents() throws Exception;
    List<Events> getUpComingEvents() throws Exception;
}
