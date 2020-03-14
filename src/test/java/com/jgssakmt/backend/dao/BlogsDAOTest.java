package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Blogs;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class BlogsDAOTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private BlogsDAO blogsDAO;

    @Test
    public void getBlogValidTest() throws Exception {
        Blogs b = blogsDAO.getBlog(1000);
        Assert.assertNotNull(b);
    }

    @Test
    public void getBlogInvalidTest() throws Exception {
        Blogs b = blogsDAO.getBlog(-1);
        Assert.assertNull(b);
    }

    @Test
    public void addNewBlogValidTest1() throws Exception {
        Blogs b = new Blogs();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Integer bId = blogsDAO.addNewBlog(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewBlogValidTest2() throws Exception {
        Blogs b = new Blogs();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Integer bId = blogsDAO.addNewBlog(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewBlogValidTest3() throws Exception {
        Blogs b = new Blogs();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Integer bId = blogsDAO.addNewBlog(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewBlogInvalidTest1() throws Exception {
        expectedException.expect(Exception.class);

        Blogs b = new Blogs();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Integer bId = blogsDAO.addNewBlog(b);
    }

    @Test
    public void addNewBlogInvalidTest2() throws Exception {
        expectedException.expect(Exception.class);

        Blogs b = new Blogs();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setTitle("Test Blog");

        Integer bId = blogsDAO.addNewBlog(b);
    }

    @Test
    public void addNewBlogInvalidTest3() throws Exception {
        expectedException.expect(Exception.class);

        Blogs b = new Blogs();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");

        Integer bId = blogsDAO.addNewBlog(b);
    }

    @Test
    public void editBlogValidTest() throws Exception {
        Blogs b = new Blogs();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Blogs bId = blogsDAO.editBlog(1000, b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void editBlogInvalidTest() throws Exception {
        Blogs b = new Blogs();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Blogs bId = blogsDAO.editBlog(550, b);
        Assert.assertNull(bId);
    }

    @Test
    public void deleteBlogValidTest() throws Exception {
        Integer bId = blogsDAO.deleteBlog(1000);
        Assert.assertNotNull(bId);
    }

    @Test
    public void deleteBlogInvalidTest() throws Exception {
        Integer bId = blogsDAO.deleteBlog(550);
        Assert.assertNull(bId);
    }
}
