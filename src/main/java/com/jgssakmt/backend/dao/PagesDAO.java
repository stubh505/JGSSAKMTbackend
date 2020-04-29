package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Pages;

import java.util.List;

public interface PagesDAO {
    List<Pages> getAllPages() throws Exception;
    Pages getPage(Integer pageId) throws Exception;
    Integer addNewPage(Pages page) throws Exception;
    Pages editPage(Integer pageId, Pages page) throws Exception;
    Integer deletePage(Integer pageId) throws Exception;
}
