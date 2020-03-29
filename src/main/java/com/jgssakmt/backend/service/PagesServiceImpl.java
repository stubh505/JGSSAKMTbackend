package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.PagesDAO;
import com.jgssakmt.backend.exeptions.PagesException;
import com.jgssakmt.backend.model.Pages;
import com.jgssakmt.backend.validator.PagesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service(value = "pagesService")
@Transactional
public class PagesServiceImpl implements PagesService {

    @Autowired
    PagesDAO pagesDAO;

    @Override
    public Pages getPage(Integer pageId) throws Exception {
        Pages page = pagesDAO.getPage(pageId);

        if (page == null)
            throw new PagesException();
        return page;
    }

    @Override
    public Integer addNewPage(Pages page) throws Exception {
        PagesValidator.validate(page);
        Integer pageId = pagesDAO.addNewPage(page);

        if (pageId == null)
            throw new PagesException();
        return pageId;
    }

    @Override
    public Pages editPage(Integer pageId, Pages page) throws Exception {
        PagesValidator.validate(page);
        Pages newPage = pagesDAO.editPage(pageId, page);

        if (newPage == null)
            throw new PagesException();
        return newPage;
    }

    @Override
    public Integer deletePage(Integer pageId) throws Exception {
        Integer page = pagesDAO.deletePage(pageId);

        if (page == null)
            throw new PagesException();
        return page;
    }
}
