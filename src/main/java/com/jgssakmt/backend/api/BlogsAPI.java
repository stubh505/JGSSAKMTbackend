package com.jgssakmt.backend.api;

import com.jgssakmt.backend.model.Blogs;
import com.jgssakmt.backend.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("BlogsAPI")
public class BlogsAPI {

    @Autowired
    Environment environment;

    @Autowired
    BlogsService blogsService;

    @GetMapping(value = "/getBlog/{blogId}")
    public ResponseEntity<Blogs> getBlog(Integer blogId) throws Exception {
        try {
            Blogs blog = blogsService.getBlog(blogId);
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(value = "/addNewBlog")
    public ResponseEntity<Integer> addNewBlog(@RequestBody Blogs blog) throws Exception {
        try {
            Integer blogId = blogsService.addNewBlog(blog);
            return new ResponseEntity<>(blogId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }
}
