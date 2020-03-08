package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Events;
import org.springframework.stereotype.Service;

@Service(value = "eventsService")
public class EventsServiceImpl implements EventsService {

    @Override
    public Events getEvent(Integer eventId) throws Exception {
        return null;
    }

    @Override
    public Integer addNewEvent(Events event) throws Exception {
        return null;
    }
}
