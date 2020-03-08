package com.jgssakmt.backend.api;

import com.jgssakmt.backend.model.Events;
import com.jgssakmt.backend.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("EventsAPI")
public class EventsAPI {

    @Autowired
    Environment environment;

    @Autowired
    EventsService eventsService;

    @GetMapping(value = "/getEvent/{eventId}")
    public ResponseEntity<Events> getBlog(Integer eventId) throws Exception {
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
}
