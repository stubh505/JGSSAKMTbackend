package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.EventsDAO;
import com.jgssakmt.backend.exeptions.EventsException;
import com.jgssakmt.backend.model.Events;
import com.jgssakmt.backend.validator.EventsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service(value = "eventsService")
@Transactional
public class EventsServiceImpl implements EventsService {

    @Autowired
    EventsDAO eventsDAO;

    @Override
    public Events getEvent(Integer eventId) throws Exception {
        Events event = eventsDAO.getEvent(eventId);

        if (event == null)
            throw new EventsException();
        return event;
    }

    @Override
    public Integer addNewEvent(Events event) throws Exception {
        EventsValidator.validate(event);
        Integer eventId = eventsDAO.addNewEvent(event);

        if (eventId == null)
            throw new EventsException();
        return eventId;
    }

    @Override
    public Events editEvent(Integer eventId, Events event) throws Exception {
        EventsValidator.validate(event);
        Events newEvent = eventsDAO.editEvent(eventId, event);

        if (newEvent == null)
            throw new EventsException();
        return newEvent;
    }

    @Override
    public Integer deleteEvent(Integer eventId) throws Exception {
        Integer event = eventsDAO.deleteEvent(eventId);

        if (event == null)
            throw new EventsException();
        return event;
    }
}
