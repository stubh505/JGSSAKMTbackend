package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.ContactUs;

import java.util.List;

public interface ContactUsDAO {
    Integer contactUs (ContactUs contactUs) throws Exception;
    ContactUs getMessage(Integer id) throws Exception;
    Integer deleteMessage (Integer id) throws Exception;
    List<ContactUs> getMessages () throws Exception;
}
