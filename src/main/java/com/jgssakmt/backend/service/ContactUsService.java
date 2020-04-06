package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.ContactUs;

import java.util.List;

public interface ContactUsService {
    Integer contactUs(ContactUs contactUs) throws Exception;
    Integer deleteMessage (Integer id) throws Exception;
    List<ContactUs> getMessages () throws Exception;
}
