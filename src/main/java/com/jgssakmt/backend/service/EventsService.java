package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Events;

public interface EventsService {
    Events getEvent(Integer eventId) throws Exception;
    Integer addNewEvent(Events event) throws Exception;
}
