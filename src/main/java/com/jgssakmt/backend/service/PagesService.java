package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Pages;

import java.util.List;

public interface PagesService {

    /**
     * Service to retrieve all data
     * @return List of pages
     * @throws Exception unable to retrieve
     */
    List<Pages> getAllPages() throws Exception;

    /**
     * Service to get individual page
     * @param pageId entity id
     * @return Page details
     * @throws Exception Unable to get page
     */
    Pages getPage(Integer pageId) throws Exception;

    /**
     * Service to add new page
     * @param page page details
     * @return persisted id
     * @throws Exception Unable to persist page
     */
    Integer addNewPage(Pages page) throws Exception;

    /**
     * Service to edit persisted page details
     * @param pageId entity id
     * @param page page details
     * @return updated details
     * @throws Exception Unable to persist
     */
    Pages editPage(Integer pageId, Pages page) throws Exception;

    /**
     * Service to delete persisted entity
     * @param pageId entity id
     * @return persisted id
     * @throws Exception unable to remove
     */
    Integer deletePage(Integer pageId) throws Exception;
}
