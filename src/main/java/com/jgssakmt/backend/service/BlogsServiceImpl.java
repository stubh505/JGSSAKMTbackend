package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Blogs;
import org.springframework.stereotype.Service;

@Service(value = "blogsService")
public class BlogsServiceImpl implements BlogsService {
    @Override
    public Blogs getBlog(Integer blogId) throws Exception {
        return null;
    }

    @Override
    public Integer addNewBlog(Blogs blog) throws Exception {
        return null;
    }
}
