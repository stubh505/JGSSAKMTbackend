package com.jgssakmt.backend.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Welcome {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to JGSSAKMTback";
    }
}
