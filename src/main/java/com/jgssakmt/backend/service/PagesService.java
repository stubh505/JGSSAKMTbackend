package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Pages;

public interface PagesService {
    Pages getPage(Integer pageId) throws Exception;
    Integer addNewPage(Pages page) throws Exception;
    Pages editPage(Integer pageId, Pages page) throws Exception;
    Integer deletePage(Integer pageId) throws Exception;
}
