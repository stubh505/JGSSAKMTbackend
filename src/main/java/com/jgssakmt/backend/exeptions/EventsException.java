package com.jgssakmt.backend.exeptions;

public class EventsException extends Exception{
    public EventsException() {
        super("An error occurred trying to fetch the event");
    }

    public EventsException(String ex) {
        super(ex);
    }
}
