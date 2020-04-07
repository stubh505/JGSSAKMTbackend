package com.jgssakmt.backend.validator;

import com.jgssakmt.backend.exeptions.ContactUsException;
import com.jgssakmt.backend.model.ContactUs;

public class ContactUsValidator {
    public static void validate (ContactUs contactUs) throws ContactUsException {
        if (contactUs.getEmail() == null || !contactUs.getEmail().matches("^[A-Za-z0-9+_.-]+@([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]+$"))
            throw new ContactUsException("Incorrect Email Format");
        if (contactUs.getMobile() == null || !contactUs.getMobile().matches("[1-9]{1}[0-9]{9}"))
            throw new ContactUsException("Incorrect Mobile Number Format");
        if (contactUs.getName() == null || contactUs.getName().equals(""))
            throw new ContactUsException("Enter a Name");
        if (contactUs.getMessage() == null || contactUs.getMessage().equals(""))
            throw new ContactUsException("Enter a Message");
    }
}
