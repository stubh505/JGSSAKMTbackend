package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.PagesDAO;
import com.jgssakmt.backend.exeptions.PagesException;
import com.jgssakmt.backend.model.Pages;
import com.jgssakmt.backend.model.Paragraph;
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
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PagesServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private PagesDAO pagesDAO;

    @InjectMocks
    private PagesServiceImpl pagesService;

    @Test
    public void getPageValidTest() throws Exception {
        Pages pages = new Pages();
        Mockito.when(pagesDAO.getPage(Mockito.anyInt())).thenReturn(pages);
        Pages b = pagesService.getPage(1000);
        Assert.assertNotNull(b);
    }

    @Test
    public void getPageInvalidTest() throws Exception {
        expectedException.expect(PagesException.class);
        Mockito.when(pagesDAO.getPage(Mockito.anyInt())).thenReturn(null);
        Pages b = pagesService.getPage(-1);
    }

    @Test
    public void addNewPageValidTest1() throws Exception {
        Pages b = new Pages();
        b.setPosted(LocalDateTime.now());
        b.setEdited(b.getPosted().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        List<Paragraph> paras = new ArrayList<>();

        Paragraph p = new Paragraph();
        p.setHeader("Test para 1");
        p.setBody("Test para 1 body");
        p.setImgUrl("http://abc.co");
        paras.add(p);

        p = new Paragraph();
        p.setHeader("Test para 2");
        p.setBody("Test para 2 body");
        p.setImgUrl("http://abc.co");
        paras.add(p);

        b.setParagraphs(paras);

        Mockito.when(pagesDAO.addNewPage(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer bId = pagesService.addNewPage(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewPageValidTest2() throws Exception {
        Pages b = new Pages();
        b.setPosted(LocalDateTime.now());
        b.setEdited(b.getPosted().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        List<Paragraph> paras = new ArrayList<>();

        Paragraph p = new Paragraph();
        p.setHeader("Test para 1");
        p.setBody("Test para 1 body");
        p.setImgUrl("http://abc.co");
        paras.add(p);

        p = new Paragraph();
        p.setHeader("Test para 2");
        p.setBody("Test para 2 body");
        paras.add(p);

        b.setParagraphs(paras);

        Mockito.when(pagesDAO.addNewPage(Mockito.any())).thenReturn(Mockito.anyInt());

        Integer bId = pagesService.addNewPage(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewPageInvalidTest1() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setPosted(LocalDateTime.now());
        b.setEdited(b.getPosted().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        List<Paragraph> paras = new ArrayList<>();

        b.setParagraphs(paras);

        Integer bId = pagesService.addNewPage(b);
    }

    @Test
    public void addNewPageInvalidTest2() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setPosted(LocalDateTime.now());
        b.setEdited(b.getPosted().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        b.setParagraphs(null);

        Integer bId = pagesService.addNewPage(b);
    }

    @Test
    public void addNewPageInvalidTest3() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setPosted(LocalDateTime.now());
        b.setEdited(b.getPosted().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        List<Paragraph> paras = new ArrayList<>();

        Paragraph p = new Paragraph();
        p.setHeader("Test para 1");
        p.setBody("Test para 1 body");
        p.setImgUrl("http://abc.co");
        paras.add(p);

        p = new Paragraph();
        p.setBody("Test para 2 body");
        paras.add(p);

        b.setParagraphs(paras);

        Integer bId = pagesService.addNewPage(b);
    }

    @Test
    public void editPageValidTest() throws Exception {
        Pages b = new Pages();
        b.setPosted(LocalDateTime.now());
        b.setEdited(b.getPosted().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        List<Paragraph> paras = new ArrayList<>();

        Paragraph p = new Paragraph();
        p.setHeader("Test para 1");
        p.setBody("Test para 1 body");
        p.setImgUrl("http://abc.co");
        paras.add(p);

        p = new Paragraph();
        p.setHeader("Test para 2");
        p.setBody("Test para 2 body");
        paras.add(p);

        b.setParagraphs(paras);

        Mockito.when(pagesDAO.editPage(Mockito.anyInt(), Mockito.any())).thenReturn(b);

        Pages bId = pagesService.editPage(1000, b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void editPageInvalidTest() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setPosted(LocalDateTime.now());
        b.setEdited(b.getPosted().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setHeader("Test Page");

        List<Paragraph> paras = new ArrayList<>();

        b.setParagraphs(paras);

        Pages bId = pagesService.editPage(550, b);
    }

    @Test
    public void deletePageValidTest() throws Exception {
        Mockito.when(pagesDAO.deletePage(Mockito.anyInt())).thenReturn(Mockito.anyInt());

        Integer bId = pagesService.deletePage(1000);
        Assert.assertNotNull(bId);
    }

    @Test
    public void deletePageInvalidTest() throws Exception {
        expectedException.expect(PagesException.class);

        Mockito.when(pagesDAO.deletePage(Mockito.anyInt())).thenReturn(null);

        Integer bId = pagesService.deletePage(550);
    }
}