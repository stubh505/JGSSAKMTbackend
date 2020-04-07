package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Blogs;

import java.util.List;

public interface BlogsDAO {
    Blogs getBlog(Integer blogId) throws Exception;
    Integer addNewBlog(Blogs blog) throws Exception;
    Blogs editBlog(Integer blogId, Blogs blog) throws Exception;
    Integer deleteBlog(Integer blogId) throws Exception;
    List<Blogs> getAllBlogs() throws Exception;
}
