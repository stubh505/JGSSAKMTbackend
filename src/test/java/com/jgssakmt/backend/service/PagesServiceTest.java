package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.PagesDAO;
import com.jgssakmt.backend.exeptions.PagesException;
import com.jgssakmt.backend.model.Pages;
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
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test page");
        b.setName("Test Page");

        Mockito.when(pagesDAO.addNewPage(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer bId = pagesService.addNewPage(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewPageValidTest2() throws Exception {
        Pages b = new Pages();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setDescription("This is a test page");
        b.setName("Test Page");

        Mockito.when(pagesDAO.addNewPage(Mockito.any())).thenReturn(Mockito.anyInt());

        Integer bId = pagesService.addNewPage(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewPageInvalidTest1() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test page");

        Integer bId = pagesService.addNewPage(b);
    }

    @Test
    public void addNewPageInvalidTest2() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setName("Test Page");

        Integer bId = pagesService.addNewPage(b);
    }

    @Test
    public void addNewPageInvalidTest3() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().minusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test page");
        b.setName("Test Page");

        Integer bId = pagesService.addNewPage(b);
    }

    @Test
    public void editPageValidTest() throws Exception {
        Pages b = new Pages();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test page");
        b.setName("Test Page");

        Mockito.when(pagesDAO.editPage(Mockito.anyInt(), Mockito.any())).thenReturn(b);

        Pages bId = pagesService.editPage(1000, b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void editPageInvalidTest() throws Exception {
        expectedException.expect(PagesException.class);

        Pages b = new Pages();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().minusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test page");
        b.setName("Test Page");

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