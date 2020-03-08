package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.BlogsEntity;
import com.jgssakmt.backend.model.Blogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BlogsDAOImpl implements BlogsDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Blogs getBlog(Integer blogId) throws Exception {
        Query query = entityManager.createQuery("select b from BlogsEntity b where b.blogId = :blogId");
        query.setParameter("blogId", blogId);
        Blogs blog = null;
        List<BlogsEntity> blogEntities = query.getResultList();
        if (!blogEntities.isEmpty()) {
            BlogsEntity blogEntity = blogEntities.get(0);
            blog = new Blogs();
            blog.setBlogId(blogEntity.getBlogId());
            blog.setContent(blogEntity.getContent());
            blog.setTitle(blogEntity.getTitle());
            blog.setImgUrl(blogEntity.getImgUrl());
        }
        return blog;
    }

    @Override
    public Integer addNewBlog(Blogs blog) throws Exception {
        return null;
    }
}
