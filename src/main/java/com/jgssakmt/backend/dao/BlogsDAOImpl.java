package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.BlogsEntity;
import com.jgssakmt.backend.model.Blogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
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
        blogsEntity.setEdited(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
        blogsEntity.setPosted(blogsEntity.getEdited());

        entityManager.persist(blogsEntity);

        return blogsEntity.getBlogId();
    }

    @Override
    public Blogs editBlog(Integer blogId, Blogs blog) throws Exception {
        BlogsEntity blogEntity = entityManager.find(BlogsEntity.class, blogId);

        if (blogEntity != null) {
            blogEntity.setEdited(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
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

    @Override
    public List<Blogs> getAllBlogs() throws Exception {
        List<Blogs> blogs = null;
        Blogs b;

        Query query = entityManager.createQuery("select b from BlogsEntity b");
        List<BlogsEntity> blogsEntities = query.getResultList();

        if (blogsEntities != null && !blogsEntities.isEmpty()) {
            blogs = new ArrayList<>();

            for (BlogsEntity be:blogsEntities) {
                b = new Blogs();
                b.setBlogId(be.getBlogId());
                b.setExcerpt(be.getExcerpt());
                b.setTitle(be.getTitle());
                b.setImgUrl(be.getImgUrl());
                b.setPosted(be.getPosted());

                blogs.add(b);
            }

            Collections.sort(blogs);
        }

        return blogs;
    }
}
