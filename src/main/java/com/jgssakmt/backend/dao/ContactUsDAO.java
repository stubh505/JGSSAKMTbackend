package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.ContactUs;

import java.util.List;

public interface ContactUsDAO {

    /**
     * Function to add sent message
     * @param contactUs message details
     * @return persisted id
     * @throws Exception Unable to persist
     */
    Integer contactUs (ContactUs contactUs) throws Exception;

    /**
     * Function to retrieve persisted message
     * @param id entity id
     * @return message details
     * @throws Exception Unable to retrieve
     */
    ContactUs getMessage(Integer id) throws Exception;

    /**
     * Function to delete persisted messages
     * @param id entity id
     * @return persisted id
     * @throws Exception Unable to delete
     */
    Integer deleteMessage (Integer id) throws Exception;

    /**
     * Function to retrieve all received messages
     * @return List of messages
     * @throws Exception Unable to retrieve
     */
    List<ContactUs> getMessages () throws Exception;
}
