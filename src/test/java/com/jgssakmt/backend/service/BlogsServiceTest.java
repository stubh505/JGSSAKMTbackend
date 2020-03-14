package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.BlogsDAO;
import com.jgssakmt.backend.exeptions.BlogsException;
import com.jgssakmt.backend.model.Blogs;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BlogsServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private BlogsDAO blogsDAO;

    @InjectMocks
    private BlogsServiceImpl blogsService;

    @Test
    public void getBlogValidTest() throws Exception {
        Blogs blogs = new Blogs();
        Mockito.when(blogsDAO.getBlog(Mockito.anyInt())).thenReturn(blogs);
        Blogs b = blogsService.getBlog(1000);
        Assert.assertNotNull(b);
    }

    @Test
    public void getBlogInvalidTest() throws Exception {
        expectedException.expect(BlogsException.class);
        Mockito.when(blogsDAO.getBlog(Mockito.anyInt())).thenReturn(null);
        Blogs b = blogsService.getBlog(-1);
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

        Mockito.when(blogsDAO.addNewBlog(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer bId = blogsService.addNewBlog(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewBlogValidTest2() throws Exception {
        Blogs b = new Blogs();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Mockito.when(blogsDAO.addNewBlog(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer bId = blogsService.addNewBlog(b);
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

        Mockito.when(blogsDAO.addNewBlog(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer bId = blogsService.addNewBlog(b);
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

        Integer bId = blogsService.addNewBlog(b);
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

        Integer bId = blogsService.addNewBlog(b);
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

        Integer bId = blogsService.addNewBlog(b);
    }

    @Test
    public void editBlogValidTest() throws Exception {
        Blogs b = new Blogs();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Blogs bId = blogsService.editBlog(1000, b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void editBlogInvalidTest() throws Exception {
        Blogs b = new Blogs();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setContent("This is a test blog");
        b.setTitle("Test Blog");

        Blogs bId = blogsService.editBlog(550, b);
        Assert.assertNull(bId);
    }

    @Test
    public void deleteBlogValidTest() throws Exception {
        Integer bId = blogsService.deleteBlog(1000);
        Assert.assertNotNull(bId);
    }

    @Test
    public void deleteBlogInvalidTest() throws Exception {
        Integer bId = blogsService.deleteBlog(550);
        Assert.assertNull(bId);
    }
}
