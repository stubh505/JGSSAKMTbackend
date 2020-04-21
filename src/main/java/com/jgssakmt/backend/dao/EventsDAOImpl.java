package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.EventsEntity;
import com.jgssakmt.backend.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<Events> getPastEvents() throws Exception {
        List<Events> events = null;
        Events e;

        Query query = entityManager.createQuery("select e from EventsEntity e where e.endTime < :today");
        query.setParameter("today", LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

        List<EventsEntity> eventsEntities = query.getResultList();

        if (eventsEntities != null && !eventsEntities.isEmpty()) {
            events = new ArrayList<>();

            for (EventsEntity ee:eventsEntities) {
                e = new Events();
                e.setName(ee.getName());
                e.setEndTime(ee.getEndTime());
                e.setStartTime(ee.getStartTime());
                e.setEventId(ee.getEventId());
                e.setExcerpt(ee.getExcerpt());
                e.setImgUrl(ee.getImgUrl());

                events.add(e);
            }

            Collections.sort(events);
        }

        return events;
    }

    @Override
    public List<Events> getAllEvents() throws Exception {
        List<Events> events = null;
        Events e;

        Query query = entityManager.createQuery("select e from EventsEntity e");

        List<EventsEntity> eventsEntities = query.getResultList();

        if (eventsEntities != null && !eventsEntities.isEmpty()) {
            events = new ArrayList<>();

            for (EventsEntity ee:eventsEntities) {
                e = new Events();
                e.setName(ee.getName());
                e.setEndTime(ee.getEndTime());
                e.setStartTime(ee.getStartTime());
                e.setEventId(ee.getEventId());
                e.setExcerpt(ee.getExcerpt());
                e.setImgUrl(ee.getImgUrl());

                events.add(e);
            }

            Collections.sort(events);
        }

        return events;
    }

    @Override
    public List<Events> getUpComingEvents() throws Exception {
        List<Events> events = null;
        Events e;

        Query query = entityManager.createQuery("select e from EventsEntity e where e.endTime >= :today");
        query.setParameter("today", LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

        List<EventsEntity> eventsEntities = query.getResultList();

        if (eventsEntities != null && !eventsEntities.isEmpty()) {
            events = new ArrayList<>();

            for (EventsEntity ee:eventsEntities) {
                e = new Events();
                e.setName(ee.getName());
                e.setEndTime(ee.getEndTime());
                e.setStartTime(ee.getStartTime());
                e.setEventId(ee.getEventId());
                e.setExcerpt(ee.getExcerpt());
                e.setImgUrl(ee.getImgUrl());

                events.add(e);
            }

            Collections.sort(events);
        }

        return events;
    }
}
