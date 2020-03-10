package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Events;

public interface EventsDAO {
    Events getEvent(Integer eventId) throws Exception;
    Integer addNewEvent(Events event) throws Exception;
    Events editEvent(Integer blogId, Events event) throws Exception;
    Integer deleteEvent(Integer blogId) throws Exception;
}
