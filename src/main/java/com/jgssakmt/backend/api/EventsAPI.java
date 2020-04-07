package com.jgssakmt.backend.api;

import com.jgssakmt.backend.model.Events;
import com.jgssakmt.backend.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("EventsAPI")
public class EventsAPI {

    @Autowired
    Environment environment;

    @Autowired
    EventsService eventsService;

    @GetMapping(value = "/getEvent/{eventId}")
    public ResponseEntity<Events> getEvent(@PathVariable Integer eventId) throws Exception {
        try {
            Events event = eventsService.getEvent(eventId);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(value = "/addNewEvent")
    public ResponseEntity<Integer> addNewEvent(@RequestBody Events event) throws Exception {
        try {
            Integer eventId = eventsService.addNewEvent(event);
            return new ResponseEntity<>(eventId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @PostMapping(value = "/editEvent")
    public ResponseEntity<Events> editEvent(@RequestBody Events event) throws Exception {
        try {
            Events eventId = eventsService.editEvent(event.getEventId(), event);
            return new ResponseEntity<>(eventId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @GetMapping(value = "/deleteEvent/{eventId}")
    public ResponseEntity<Integer> deleteEvent(@PathVariable Integer eventId) throws Exception {
        try {
            Integer event = eventsService.deleteEvent(eventId);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @GetMapping(value = "/getPastEvents")
    public ResponseEntity<List<Events>> getPastEvents() throws Exception {
        try {
            List<Events> events = eventsService.getPastEvents();
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/getAllEvents")
    public ResponseEntity<List<Events>> getAllEvents() throws Exception {
        try {
            List<Events> events = eventsService.getAllEvents();
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/getUpComingEvents")
    public ResponseEntity<List<Events>> getUpComingEvents() throws Exception {
        try {
            List<Events> events = eventsService.getUpComingEvents();
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
