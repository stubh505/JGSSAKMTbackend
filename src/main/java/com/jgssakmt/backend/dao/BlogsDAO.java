package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Blogs;

import java.util.List;

public interface BlogsDAO {

    /**
     * Function to retrieve blog details from db
     * @param blogId Blog id
     * @return blog
     * @throws Exception Unable to get blog
     */
    Blogs getBlog(Integer blogId) throws Exception;

    /**
     * Function to persist new blog in db
     * @param blog Blog body
     * @return persisted entity id
     * @throws Exception Unable to persist
     */
    Integer addNewBlog(Blogs blog) throws Exception;

    /**
     * Function to update existing entity
     * @param blogId blog id
     * @param blog blog body
     * @return updated blog
     * @throws Exception Unable to update
     */
    Blogs editBlog(Integer blogId, Blogs blog) throws Exception;

    /**
     * Function to delete persisted entity
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
