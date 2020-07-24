package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Events;

import java.util.List;

public interface EventsService {

    /**
     * Service to retrieve Event details
     * @param eventId entity id
     * @return Event details
     * @throws Exception Unable to retrieve
     */
    Events getEvent(Integer eventId) throws Exception;

    /**
     * Service to add new Event to the db
     * @param event Event data
     * @return persisted id
     * @throws Exception Unable to persist
     */
    Integer addNewEvent(Events event) throws Exception;

    /**
     * Service to update existing event entity
     * @param blogId entity id
     * @param event updated event details
     * @return updated data
     * @throws Exception Unable to persist
     */
    Events editEvent(Integer blogId, Events event) throws Exception;

    /**
     * Service to delete existing entity
     * @param blogId entity id
     * @return persisted id
     * @throws Exception Unable to delete
     */
    Integer deleteEvent(Integer blogId) throws Exception;

    /**
     * Service to retrieve event prior to current date
     * @return List of events
     * @throws Exception Unable to retrieve
     */
    List<Events> getPastEvents() throws Exception;

    /**
     * Service to retrieve all event
     * @return List of events
     * @throws Exception Unable to retrieve
     */
    List<Events> getAllEvents() throws Exception;

    /**
     * Service to retrieve event after the current date
     * @return List of events
     * @throws Exception Unable to retrieve
     */
    List<Events> getUpComingEvents() throws Exception;
}
