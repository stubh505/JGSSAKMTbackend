package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Blogs;

public interface BlogsService {
    public Blogs getBlog(Integer blogId) throws Exception;
    public Integer addNewBlog(Blogs blog) throws Exception;
}
