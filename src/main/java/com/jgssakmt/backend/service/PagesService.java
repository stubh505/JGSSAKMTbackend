package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Pages;

public interface PagesService {
    Pages getPage(Integer pageId) throws Exception;
    Integer addNewPage(Pages page) throws Exception;
}
