package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Blogs;

public interface BlogsDAO {
    Blogs getBlog(Integer blogId) throws Exception;
    Integer addNewBlog(Blogs blog) throws Exception;
}
