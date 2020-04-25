package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.ContactUsDAO;
import com.jgssakmt.backend.exeptions.ContactUsException;
import com.jgssakmt.backend.model.ContactUs;
import com.jgssakmt.backend.validator.ContactUsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service(value = "contactUsService")
@Transactional
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    ContactUsDAO contactUsDAO;

    @Override
    public Integer contactUs(ContactUs contactUs) throws Exception {
        ContactUsValidator.validate(contactUs);
        Integer i = contactUsDAO.contactUs(contactUs);

        if (i == null)
            throw new ContactUsException("An error occurred while contacting");

        return i;
    }

    @Override
    public ContactUs getMessage(Integer id) throws Exception {
        if (id == null)
            throw new ContactUsException("Error occurred trying to retrieve message");

        ContactUs message = contactUsDAO.getMessage(id);
        return message;
    }

    @Override
    public Integer deleteMessage(Integer id) throws Exception {
        Integer i = contactUsDAO.deleteMessage(id);

        if (i == null)
            throw new ContactUsException("An error occurred while deleting");

        return i;
    }

    @Override
    public List<ContactUs> getMessages() throws Exception {
        List<ContactUs> messages = contactUsDAO.getMessages();

        if (messages == null || messages.isEmpty()) {
            throw new ContactUsException("An error occurred while retrieving messages");
        }
        return messages;
    }
}
