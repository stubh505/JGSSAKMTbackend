package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.ContactUsEntity;
import com.jgssakmt.backend.model.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository(value = "contactUsDAO")
public class ContactUsDAOImpl implements ContactUsDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public Integer contactUs(ContactUs contactUs) throws Exception {
        Integer i = null;

        if (contactUs != null) {
            ContactUsEntity contactUsEntity = new ContactUsEntity();
            contactUsEntity.setEmail(contactUs.getEmail());
            contactUsEntity.setMessage(contactUs.getMessage());
            contactUsEntity.setMobile(contactUs.getMobile());

            entityManager.persist(contactUsEntity);

            i = contactUsEntity.getId();
        }

        return i;
    }
}
