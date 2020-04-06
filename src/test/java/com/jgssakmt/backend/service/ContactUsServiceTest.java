package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.ContactUsDAO;
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
    public void getBlogValidTest() throws Exception {
        ContactUs contactUs = new ContactUs();

        contactUs.setEmail("kaus@gmail.com");
        contactUs.setName("Kaus");
        contactUs.setMessage("Test");
        contactUs.setMobile("8961230458");

        Mockito.when(contactUsDAO.contactUs(Mockito.any())).thenReturn(Mockito.anyInt());
        Integer b = contactUsService.contactUs(contactUs);
        Assert.assertNotNull(b);
    }

}
