package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.EventsEntity;
import com.jgssakmt.backend.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EventsDAOImpl implements EventsDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Events getEvent(Integer eventId) throws Exception {
        Query query = entityManager.createQuery("select b from EventsEntity b where b.eventId = :eventId");
        query.setParameter("eventId", eventId);

        Events event = null;
        List<EventsEntity> eventEntities = query.getResultList();

        if (!eventEntities.isEmpty()) {
            EventsEntity eventEntity = eventEntities.get(0);
            event = new Events();
            event.setEventId(eventEntity.getEventId());
            event.setDescription(eventEntity.getDescription());
            event.setEndTime(eventEntity.getEndTime());
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
        eventsEntity.setStartTime(event.getStartTime());

        entityManager.persist(eventsEntity);

        return eventsEntity.getEventId();
    }

    @Override
    public Events editEvent(Integer eventId, Events event) throws Exception {
        Query query = entityManager.createQuery("select b from EventsEntity b where b.eventId = :eventId");
        query.setParameter("eventId", eventId);

        List<EventsEntity> eventEntities = query.getResultList();

        if (!eventEntities.isEmpty()) {
            EventsEntity eventEntity = eventEntities.get(0);

            eventEntity.setDescription(event.getDescription());
            eventEntity.setEndTime(event.getEndTime());
            eventEntity.setImgUrl(event.getImgUrl());
            eventEntity.setName(event.getName());
            eventEntity.setStartTime(event.getStartTime());
            
            entityManager.persist(eventEntity);
            
            event.setEventId(eventEntity.getEventId());
            
            return event;
        }

        return null;
    }

    @Override
    public Integer deleteEvent(Integer eventId) throws Exception {
        Query query = entityManager.createQuery("select b from EventsEntity b where b.eventId = :eventId");
        query.setParameter("eventId", eventId);

        List<EventsEntity> eventEntities = query.getResultList();

        if (!eventEntities.isEmpty()) {
            EventsEntity eventEntity = eventEntities.get(0);

            entityManager.remove(eventEntity);

            return eventEntity.getEventId();
        }
        
        return null;
    }
}
