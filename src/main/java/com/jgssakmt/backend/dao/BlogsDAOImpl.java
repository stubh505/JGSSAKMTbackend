package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.BlogsEntity;
import com.jgssakmt.backend.model.Blogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BlogsDAOImpl implements BlogsDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Blogs getBlog(Integer blogId) throws Exception {
        BlogsEntity blogEntity = entityManager.find(BlogsEntity.class, blogId);

        Blogs blog = null;
        if (blogEntity != null) {
            blog = new Blogs();
            blog.setBlogId(blogEntity.getBlogId());
            blog.setEdited(blogEntity.getEdited());
            blog.setPosted(blogEntity.getPosted());
            blog.setExcerpt(blogEntity.getExcerpt());
            blog.setContent(blogEntity.getContent());
            blog.setTitle(blogEntity.getTitle());
            blog.setImgUrl(blogEntity.getImgUrl());
        }

        return blog;
    }

    @Override
    public Integer addNewBlog(Blogs blog) throws Exception {
        BlogsEntity blogsEntity = new BlogsEntity();
        blogsEntity.setTitle(blog.getTitle());
        blogsEntity.setContent(blog.getContent());
        blogsEntity.setImgUrl(blog.getImgUrl());
        blogsEntity.setExcerpt(blog.getExcerpt());
        blogsEntity.setEdited(LocalDateTime.now());
        blogsEntity.setPosted(blogsEntity.getEdited());

        entityManager.persist(blogsEntity);

        return blogsEntity.getBlogId();
    }

    @Override
    public Blogs editBlog(Integer blogId, Blogs blog) throws Exception {
        BlogsEntity blogEntity = entityManager.find(BlogsEntity.class, blogId);

        if (blogEntity != null) {
            blogEntity.setEdited(LocalDateTime.now());
            blogEntity.setImgUrl(blog.getImgUrl());
            blogEntity.setContent(blog.getContent());
            blogEntity.setExcerpt(blog.getExcerpt());
            blogEntity.setTitle(blog.getTitle());

            entityManager.persist(blogEntity);

            blog.setEdited(blogEntity.getEdited());

            return blog;
        }

        return null;
    }

    @Override
    public Integer deleteBlog(Integer blogId) throws Exception {
        BlogsEntity blogEntity = entityManager.find(BlogsEntity.class, blogId);

        if (blogEntity != null) {
            entityManager.remove(blogEntity);

            return blogEntity.getBlogId();
        }

        return null;
    }
}
