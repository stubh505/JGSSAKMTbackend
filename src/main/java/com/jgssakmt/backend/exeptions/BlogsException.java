package com.jgssakmt.backend.exeptions;

public class BlogsException extends Exception {
    public BlogsException() {
        super("An error occurred trying to fetch the blog");
    }
}
