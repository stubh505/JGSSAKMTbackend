package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Blogs;

import java.util.List;

public interface BlogsService {

    /**
     * Service to retrieve blog details from db
     * @param blogId Blog id
     * @return blog
     * @throws Exception Unable to get blog
     */
    Blogs getBlog(Integer blogId) throws Exception;
    
    /**
     * Service to persist new blog in db
     * @param blog Blog body
     * @return persisted entity id
     * @throws Exception Unable to persist
     */
    Integer addNewBlog(Blogs blog) throws Exception;

    /**
     * Service to update existing entity
     * @param blogId blog id
     * @param blog blog body
     * @return updated blog
     * @throws Exception Unable to update
     */
    Blogs editBlog(Integer blogId, Blogs blog) throws Exception;

    /**
     * Service to delete persisted entity
     * @param blogId blog id
     * @return persisted id
     * @throws Exception Unable to delete
     */
    Integer deleteBlog(Integer blogId) throws Exception;

    /**
     * Returns all blogs
     * @return all blogs
     * @throws Exception Unable to get blogs
     */
    List<Blogs> getAllBlogs() throws Exception;
}
