package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Events;
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
public class EventsDAOTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private EventsDAO eventsDAO;

    @Test
    public void getEventValidTest() throws Exception {
        Events b = eventsDAO.getEvent(1000);
        Assert.assertNotNull(b);
    }

    @Test
    public void getEventInvalidTest() throws Exception {
        Events b = eventsDAO.getEvent(-1);
        Assert.assertNull(b);
    }

    @Test
    public void addNewEventValidTest1() throws Exception {
        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime());
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Integer bId = eventsDAO.addNewEvent(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewEventValidTest2() throws Exception {
        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime());
        b.setExcerpt("This is a test excerpt.");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Integer bId = eventsDAO.addNewEvent(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewEventInvalidTest1() throws Exception {
        expectedException.expect(Exception.class);

        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime());
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Integer bId = eventsDAO.addNewEvent(b);
    }

    @Test
    public void addNewEventInvalidTest2() throws Exception {
        expectedException.expect(Exception.class);

        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime());
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");

        Integer bId = eventsDAO.addNewEvent(b);
    }

    @Test
    public void addNewEventInvalidTest3() throws Exception {
        expectedException.expect(Exception.class);

        Events b = new Events();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Integer bId = eventsDAO.addNewEvent(b);
    }

    @Test
    public void editEventValidTest() throws Exception {
        Events b = new Events();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Events bId = eventsDAO.editEvent(1000, b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void editEventInvalidTest() throws Exception {
        Events b = new Events();
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Events bId = eventsDAO.editEvent(550, b);
        Assert.assertNull(bId);
    }

    @Test
    public void deleteEventValidTest() throws Exception {
        Integer bId = eventsDAO.deleteEvent(1000);
        Assert.assertNotNull(bId);
    }

    @Test
    public void deleteEventInvalidTest() throws Exception {
        Integer bId = eventsDAO.deleteEvent(550);
        Assert.assertNull(bId);
    }
}
