package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.ContactUsEntity;
import com.jgssakmt.backend.model.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
            contactUsEntity.setName(contactUs.getName());
            contactUsEntity.setMessage(contactUs.getMessage());
            contactUsEntity.setMobile(contactUs.getMobile());

            entityManager.persist(contactUsEntity);

            i = contactUsEntity.getId();
        }

        return i;
    }

    @Override
    public Integer deleteMessage(Integer id) throws Exception {
        Integer i = null;

        if (id != null) {
            ContactUsEntity entity = entityManager.find(ContactUsEntity.class, id);
             if (entity != null) {
                 entityManager.remove(entity);

                 i = entity.getId();
             }
        }

        return i;
    }

    @Override
    public List<ContactUs> getMessages() throws Exception {
        List<ContactUs> messages = null;
        ContactUs contactUs = null;

        Query query = entityManager.createQuery("select c from ContactUsEntity c");
        List<ContactUsEntity> messageEntities = query.getResultList();

        if (messageEntities != null && !messageEntities.isEmpty()) {
            messages = new ArrayList<>();

            for (ContactUsEntity entity:messageEntities) {
                contactUs = new ContactUs();
                contactUs.setMobile(entity.getMobile());
                contactUs.setMessage(entity.getMessage());
                contactUs.setName(entity.getName());
                contactUs.setEmail(entity.getEmail());
                contactUs.setId(entity.getId());

                messages.add(contactUs);
            }
        }
        return messages;
    }
}
