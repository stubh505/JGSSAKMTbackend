package com.jgssakmt.backend.api;

import com.jgssakmt.backend.model.Blogs;
import com.jgssakmt.backend.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("BlogsAPI")
public class BlogsAPI {

    @Autowired
    BlogsService blogsService;

    @GetMapping(value = "/getBlog/{blogId}")
    public ResponseEntity<Blogs> getBlog(@PathVariable Integer blogId) throws Exception {
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

    @PutMapping(value = "/editBlog/{id}")
    public ResponseEntity<Blogs> editBlog(@PathVariable Integer id, @RequestBody Blogs blog) throws Exception {
        try {
            Blogs blogId = blogsService.editBlog(id, blog);
            return new ResponseEntity<>(blogId, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deleteBlog/{blogId}")
    public ResponseEntity<Integer> deleteBlog(@PathVariable Integer blogId) throws Exception {
        try {
            Integer blog = blogsService.deleteBlog(blogId);
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @GetMapping(value = "/getAllBlogs")
    public ResponseEntity<List<Blogs>> getAllBlogs() {
        try {
            List<Blogs> blog = blogsService.getAllBlogs();
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
