package com.jgssakmt.backend.exeptions;

public class CarouselException extends Exception {
    public CarouselException() {
        super("Error Occurred trying to retrieve Carousels");
    }
    public CarouselException(String e) {
        super(e);
    }
}
