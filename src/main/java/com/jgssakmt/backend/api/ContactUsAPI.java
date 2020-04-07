package com.jgssakmt.backend.api;

import com.jgssakmt.backend.model.ContactUs;
import com.jgssakmt.backend.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("ContactUsAPI")
public class ContactUsAPI {

    @Autowired
    Environment environment;

    @Autowired
    ContactUsService contactUsService;

    @PostMapping(value = "/contactUs")
    public ResponseEntity<Integer> contactUs(@RequestBody ContactUs contactUs) throws Exception {
        try {
            Integer blogId = contactUsService.contactUs(contactUs);
            return new ResponseEntity<>(blogId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deleteMessage/{id}")
    public ResponseEntity<Integer> deleteMessage(@PathVariable Integer id) {
        try {
            Integer blogId = contactUsService.deleteMessage(id);
            return new ResponseEntity<>(blogId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/getMessages")
    public ResponseEntity<List<ContactUs>> getMessages() {
        try {
            List<ContactUs> blogId = contactUsService.getMessages();
            return new ResponseEntity<>(blogId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }
}