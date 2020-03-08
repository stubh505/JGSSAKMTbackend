package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Blogs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class BlogsDAOTest {

    @Autowired
    private BlogsDAO blogsDAO;

    @Test
    public void getBlogValidTest() throws Exception {
        Blogs b = blogsDAO.getBlog(1);
        System.out.println(b.getBlogId() +" "+ b.getTitle()+" "+b.getImgUrl());
    }

}
