package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.EventsEntity;
import com.jgssakmt.backend.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository(value = "eventsDAO")
public class EventsDAOImpl implements EventsDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Events getEvent(Integer eventId) throws Exception {
        EventsEntity eventEntity = entityManager.find(EventsEntity.class, eventId);

        Events event = null;

        if (eventEntity != null) {
            event = new Events();
            event.setEventId(eventEntity.getEventId());
            event.setDescription(eventEntity.getDescription());
            event.setEndTime(eventEntity.getEndTime());
            event.setExcerpt(eventEntity.getExcerpt());
            event.setImgUrl(eventEntity.getImgUrl());
            event.setName(eventEntity.getName());
            event.setStartTime(eventEntity.getStartTime());
        }

        return event;
    }

    @Override
    public Integer addNewEvent(Events event) throws Exception {
        EventsEntity eventsEntity = new EventsEntity();
        eventsEntity.setImgUrl(event.getImgUrl());
        eventsEntity.setDescription(event.getDescription());
        eventsEntity.setEndTime(event.getEndTime());
        eventsEntity.setName(event.getName());
        eventsEntity.setExcerpt(event.getExcerpt());
        eventsEntity.setStartTime(event.getStartTime());

        entityManager.persist(eventsEntity);

        return eventsEntity.getEventId();
    }

    @Override
    public Events editEvent(Integer eventId, Events event) throws Exception {
        EventsEntity eventEntity = entityManager.find(EventsEntity.class, eventId);

        if (eventEntity != null) {
            eventEntity.setDescription(event.getDescription());
            eventEntity.setEndTime(event.getEndTime());
            eventEntity.setImgUrl(event.getImgUrl());
            eventEntity.setName(event.getName());
            eventEntity.setExcerpt(event.getExcerpt());
            eventEntity.setStartTime(event.getStartTime());
            
            entityManager.persist(eventEntity);
            
            event.setEventId(eventEntity.getEventId());
            
            return event;
        }

        return null;
    }

    @Override
    public Integer deleteEvent(Integer eventId) throws Exception {
        EventsEntity eventEntity = entityManager.find(EventsEntity.class, eventId);

        if (eventEntity != null) {
            entityManager.remove(eventEntity);

            return eventEntity.getEventId();
        }
        
        return null;
    }
}
