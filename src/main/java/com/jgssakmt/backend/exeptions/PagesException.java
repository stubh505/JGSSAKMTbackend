package com.jgssakmt.backend.exeptions;

public class PagesException extends Exception{
    public PagesException() {
        super("An error occurred trying to fetch the page");
    }
}
