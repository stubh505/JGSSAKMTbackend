package com.jgssakmt.backend.api;

import com.jgssakmt.backend.model.Pages;
import com.jgssakmt.backend.service.PagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("PagesAPI")
public class PagesAPI {

    @Autowired
    Environment environment;

    @Autowired
    PagesService pagesService;

    @GetMapping(value = "/getAllPages")
    public ResponseEntity<List<Pages>> getAllPages() throws Exception {
        try {
            List<Pages> pages = pagesService.getAllPages();
            return new ResponseEntity<>(pages, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/getPage/{pageId}")
    public ResponseEntity<Pages> getPage(@PathVariable Integer pageId) throws Exception {
        try {
            Pages page = pagesService.getPage(pageId);
            return new ResponseEntity<>(page, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(value = "/addNewPage")
    public ResponseEntity<Integer> addNewPage(@RequestBody Pages page) throws Exception {
        try {
            Integer pageId = pagesService.addNewPage(page);
            return new ResponseEntity<>(pageId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @PutMapping(value = "/editPage/{id}")
    public ResponseEntity<Pages> editPage(@PathVariable Integer id, @RequestBody Pages page) throws Exception {
        try {
            Pages pageId = pagesService.editPage(id, page);
            return new ResponseEntity<>(pageId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletePage/{pageId}")
    public ResponseEntity<Integer> deletePage(@PathVariable Integer pageId) throws Exception {
        try {
            Integer page = pagesService.deletePage(pageId);
            return new ResponseEntity<>(page, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }
}
