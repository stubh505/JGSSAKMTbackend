package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.ContactUsDAO;
import com.jgssakmt.backend.exeptions.ContactUsException;
import com.jgssakmt.backend.model.ContactUs;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class ContactUsServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private ContactUsDAO contactUsDAO;

    @InjectMocks
    private ContactUsServiceImpl contactUsService;

    @Test
    public void getContactUsValidTest() throws Exception {
        ContactUs contactUs = new ContactUs();

        contactUs.setEmail("kaus@gmail.com");
        contactUs.setName("Kaus");
        contactUs.setMessage("Test");
        contactUs.setMobile("8961230458");

        Mockito.when(contactUsDAO.contactUs(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer b = contactUsService.contactUs(contactUs);
        Assert.assertNotNull(b);
    }

    @Test
    public void getContactUsInvalidTest1() throws Exception {
        expectedException.expect(ContactUsException.class);
        expectedException.expectMessage("Enter a Name");

        ContactUs contactUs = new ContactUs();

        contactUs.setEmail("kaus@gmail.com");
        contactUs.setName("");
        contactUs.setMessage("Test");
        contactUs.setMobile("8961230458");

        Mockito.when(contactUsDAO.contactUs(Mockito.any())).thenReturn(null);
        contactUsService.contactUs(contactUs);
    }

    @Test
    public void getContactUsInvalidTest2() throws Exception {
        expectedException.expect(ContactUsException.class);
        expectedException.expectMessage("Incorrect Email Format");

        ContactUs contactUs = new ContactUs();

        contactUs.setEmail("kaus@gmail");
        contactUs.setName("Test");
        contactUs.setMessage("Test");
        contactUs.setMobile("8961230458");

        Mockito.when(contactUsDAO.contactUs(Mockito.any())).thenReturn(null);
        contactUsService.contactUs(contactUs);
    }

    @Test
    public void getContactUsInvalidTest3() throws Exception {
        expectedException.expect(ContactUsException.class);
        expectedException.expectMessage("Incorrect Mobile Number Format");

        ContactUs contactUs = new ContactUs();

        contactUs.setEmail("kaus@gmail.com");
        contactUs.setName("Test");
        contactUs.setMessage("Test");
        contactUs.setMobile("89612304");

        Mockito.when(contactUsDAO.contactUs(Mockito.any())).thenReturn(null);
        contactUsService.contactUs(contactUs);
    }

    @Test
    public void getContactUsInvalidTest4() throws Exception {
        expectedException.expect(ContactUsException.class);
        expectedException.expectMessage("Enter a Message");

        ContactUs contactUs = new ContactUs();

        contactUs.setEmail("kaus@gmail.com");
        contactUs.setName("Test");
        contactUs.setMessage("");
        contactUs.setMobile("8961230478");

        Mockito.when(contactUsDAO.contactUs(Mockito.any())).thenReturn(null);
        contactUsService.contactUs(contactUs);
    }

    @Test
    public void getMessagesValidTest() throws Exception {
        List<ContactUs> messages = new ArrayList<>();
        messages.add(new ContactUs());

        Mockito.when(contactUsDAO.getMessages()).thenReturn(messages);
        Assert.assertNotNull(contactUsService.getMessages());
    }

    @Test
    public void getMessagesInvalidTest() throws Exception {
        expectedException.expect(ContactUsException.class);
        expectedException.expectMessage("An error occurred while retrieving messages");

        List<ContactUs> messages = new ArrayList<>();

        Mockito.when(contactUsDAO.getMessages()).thenReturn(messages);
        contactUsService.getMessages();
    }

    @Test
    public void deleteMessageValidTest() throws Exception {
        Mockito.when(contactUsDAO.deleteMessage(Mockito.anyInt())).thenReturn(Mockito.anyInt());
        Assert.assertNotNull(contactUsService.deleteMessage(5));
    }

    @Test
    public void deleteMessageInvalidTest() throws Exception {
        expectedException.expect(ContactUsException.class);
        expectedException.expectMessage("An error occurred while deleting");

        Mockito.when(contactUsDAO.deleteMessage(Mockito.anyInt())).thenReturn(null);
        contactUsService.deleteMessage(5);
    }
}
