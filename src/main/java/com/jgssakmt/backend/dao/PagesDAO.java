package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Pages;

public interface PagesDAO {
    Pages getPage(Integer pageId) throws Exception;
    Integer addNewPage(Pages page) throws Exception;
    Pages editPage(Integer pageId, Pages page) throws Exception;
    Integer deletePage(Integer pageId) throws Exception;
}
