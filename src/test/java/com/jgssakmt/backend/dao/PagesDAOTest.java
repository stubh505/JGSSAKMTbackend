package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Pages;
import com.jgssakmt.backend.model.Paragraph;
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
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class PagesDAOTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private PagesDAO pagesDAO;

    @Test
    public void getPageValidTest() throws Exception {
        Pages b = pagesDAO.getPage(1000);
        Assert.assertNotNull(b);
    }

    @Test
    public void getPageInvalidTest() throws Exception {
        Pages b = pagesDAO.getPage(-1);
        Assert.assertNull(b);
    }

    @Test
    public void addNewPageValidTest1() throws Exception {
        Pages b = new Pages();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        Paragraph p = new Paragraph();
        p.setImgUrl("http://abc.co");
        p.setBody("This is a test page");
        p.setHeader("Test Page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Integer bId = pagesDAO.addNewPage(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewPageValidTest2() throws Exception {
        Pages b = new Pages();
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        Paragraph p = new Paragraph();
        p.setImgUrl("http://abc.co");
        p.setBody("This is a test page");
        p.setHeader("Test Page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Integer bId = pagesDAO.addNewPage(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewPageValidTest3() throws Exception {
        Pages b = new Pages();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        Paragraph p = new Paragraph();
        p.setBody("This is a test page");
        p.setHeader("Test Page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Integer bId = pagesDAO.addNewPage(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewPageInvalidTest1() throws Exception {
        expectedException.expect(Exception.class);

        Pages b = new Pages();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());

        Paragraph p = new Paragraph();
        p.setImgUrl("http://abc.co");
        p.setBody("This is a test page");
        p.setHeader("Test Page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Integer bId = pagesDAO.addNewPage(b);
    }

    @Test
    public void addNewPageInvalidTest2() throws Exception {
        expectedException.expect(Exception.class);

        Pages b = new Pages();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");

        Paragraph p = new Paragraph();
        p.setImgUrl("http://abc.co");
        p.setHeader("Test Page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Integer bId = pagesDAO.addNewPage(b);
    }

    @Test
    public void addNewPageInvalidTest3() throws Exception {
        expectedException.expect(Exception.class);

        Pages b = new Pages();
        b.setEdited(LocalDateTime.now());
        b.setPosted(b.getEdited());
        b.setExcerpt("This is a test excerpt.");

        Paragraph p = new Paragraph();
        p.setImgUrl("http://abc.co");
        p.setBody("This is a test page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Integer bId = pagesDAO.addNewPage(b);
    }

    @Test
    public void editPageValidTest() throws Exception {
        Pages b = new Pages();
        b.setExcerpt("This is a test excerpt.");

        Paragraph p = new Paragraph();
        p.setImgUrl("http://abc.co");
        p.setBody("This is a test page");
        p.setHeader("Test Page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Pages bId = pagesDAO.editPage(1000, b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void editPageInvalidTest() throws Exception {
        Pages b = new Pages();
        b.setExcerpt("This is a test excerpt.");

        Paragraph p = new Paragraph();
        p.setImgUrl("http://abc.co");
        p.setBody("This is a test page");
        p.setHeader("Test Page");

        List<Paragraph> ps = new ArrayList<>();
        ps.add(p);

        b.setParagraphs(ps);

        Pages bId = pagesDAO.editPage(550, b);
        Assert.assertNull(bId);
    }

    @Test
    public void deletePageValidTest() throws Exception {
        Integer bId = pagesDAO.deletePage(1000);
        Assert.assertNotNull(bId);
    }

    @Test
    public void deletePageInvalidTest() throws Exception {
        Integer bId = pagesDAO.deletePage(550);
        Assert.assertNull(bId);
    }
}
