package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Blogs;

public interface BlogsService {
    Blogs getBlog(Integer blogId) throws Exception;
    Integer addNewBlog(Blogs blog) throws Exception;
    Blogs editBlog(Integer blogId, Blogs blog) throws Exception;
    Integer deleteBlog(Integer blogId) throws Exception;
}
