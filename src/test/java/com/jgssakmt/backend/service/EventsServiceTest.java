package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.EventsDAO;
import com.jgssakmt.backend.exeptions.EventsException;
import com.jgssakmt.backend.model.Events;
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
public class EventsServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private EventsDAO eventsDAO;

    @InjectMocks
    private EventsServiceImpl eventsService;

    @Test
    public void getEventValidTest() throws Exception {
        Events events = new Events();
        Mockito.when(eventsDAO.getEvent(Mockito.anyInt())).thenReturn(events);
        Events b = eventsService.getEvent(1000);
        Assert.assertNotNull(b);
    }

    @Test
    public void getEventInvalidTest() throws Exception {
        expectedException.expect(EventsException.class);
        Mockito.when(eventsDAO.getEvent(Mockito.anyInt())).thenReturn(null);
        Events b = eventsService.getEvent(-1);
    }

    @Test
    public void addNewEventValidTest1() throws Exception {
        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Mockito.when(eventsDAO.addNewEvent(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer bId = eventsService.addNewEvent(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewEventValidTest2() throws Exception {
        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Mockito.when(eventsDAO.addNewEvent(Mockito.any())).thenReturn(Mockito.anyInt());

        Integer bId = eventsService.addNewEvent(b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void addNewEventInvalidTest1() throws Exception {
        expectedException.expect(EventsException.class);

        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");

        Integer bId = eventsService.addNewEvent(b);
    }

    @Test
    public void addNewEventInvalidTest2() throws Exception {
        expectedException.expect(EventsException.class);

        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setName("Test Event");

        Integer bId = eventsService.addNewEvent(b);
    }

    @Test
    public void addNewEventInvalidTest3() throws Exception {
        expectedException.expect(EventsException.class);

        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().minusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Integer bId = eventsService.addNewEvent(b);
    }

    @Test
    public void editEventValidTest() throws Exception {
        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().plusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Mockito.when(eventsDAO.editEvent(Mockito.anyInt(), Mockito.any())).thenReturn(b);

        Events bId = eventsService.editEvent(1000, b);
        Assert.assertNotNull(bId);
    }

    @Test
    public void editEventInvalidTest() throws Exception {
        expectedException.expect(EventsException.class);

        Events b = new Events();
        b.setStartTime(LocalDateTime.now());
        b.setEndTime(b.getStartTime().minusDays(1));
        b.setExcerpt("This is a test excerpt.");
        b.setImgUrl("http://abc.co");
        b.setDescription("This is a test event");
        b.setName("Test Event");

        Events bId = eventsService.editEvent(550, b);
    }

    @Test
    public void deleteEventValidTest() throws Exception {
        Mockito.when(eventsDAO.deleteEvent(Mockito.anyInt())).thenReturn(Mockito.anyInt());

        Integer bId = eventsService.deleteEvent(1000);
        Assert.assertNotNull(bId);
    }

    @Test
    public void deleteEventInvalidTest() throws Exception {
        expectedException.expect(EventsException.class);

        Mockito.when(eventsDAO.deleteEvent(Mockito.anyInt())).thenReturn(null);

        Integer bId = eventsService.deleteEvent(550);
    }
}