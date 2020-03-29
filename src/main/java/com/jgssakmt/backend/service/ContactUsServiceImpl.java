package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.ContactUsDAO;
import com.jgssakmt.backend.exeptions.ContactUsException;
import com.jgssakmt.backend.model.ContactUs;
import com.jgssakmt.backend.validator.ContactUsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service(value = "contactUsService")
@Transactional
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    ContactUsDAO contactUsDAO;

    @Override
    public Integer contactUs(ContactUs contactUs) throws Exception {
        Integer i = null;

        if (contactUs != null) {
            ContactUsValidator.validate(contactUs);

            i = contactUsDAO.contactUs(contactUs);
        } else {
            throw new ContactUsException("An error occurred while contacting");
        }
        return i;
    }
}
