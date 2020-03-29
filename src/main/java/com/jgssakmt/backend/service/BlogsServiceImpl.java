package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.BlogsDAO;
import com.jgssakmt.backend.exeptions.BlogsException;
import com.jgssakmt.backend.model.Blogs;
import com.jgssakmt.backend.validator.BlogsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service(value = "blogsService")
@Transactional
public class BlogsServiceImpl implements BlogsService {

    @Autowired
    BlogsDAO blogsDAO;

    @Override
    public Blogs getBlog(Integer blogId) throws Exception {
        Blogs blog = blogsDAO.getBlog(blogId);

        if (blog == null)
            throw new BlogsException();
        return blog;
    }

    @Override
    public Integer addNewBlog(Blogs blog) throws Exception {
        BlogsValidator.validate(blog);

        Integer blogId = blogsDAO.addNewBlog(blog);

        if (blogId == null)
            throw new BlogsException();
        return blogId;
    }

    @Override
    public Blogs editBlog(Integer blogId, Blogs blog) throws Exception {
        BlogsValidator.validate(blog);
        Blogs newBlog = blogsDAO.editBlog(blogId, blog);

        if (newBlog == null)
            throw new BlogsException();
        return newBlog;
    }

    @Override
    public Integer deleteBlog(Integer blogId) throws Exception {
        Integer blog = blogsDAO.deleteBlog(blogId);

        if (blog == null)
            throw new BlogsException();
        return blog;
    }
}
