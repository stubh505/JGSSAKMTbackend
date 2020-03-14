package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.PagesEntity;
import com.jgssakmt.backend.entity.ParagraphsEntity;
import com.jgssakmt.backend.model.Pages;
import com.jgssakmt.backend.model.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "pagesDAO")
public class PagesDAOImpl implements PagesDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Pages getPage(Integer pageId) throws Exception {
        PagesEntity pageEntity = entityManager.find(PagesEntity.class, pageId);

        Pages page = null;
        if (pageEntity != null) {
            page = new Pages();
            page.setPageId(pageEntity.getPageId());
            page.setEdited(pageEntity.getEdited());
            page.setPosted(pageEntity.getPosted());
            page.setHeader(pageEntity.getHeader());
            page.setExcerpt(pageEntity.getExcerpt());

            List<Paragraph> paras = null;

            if (pageEntity.getParagraphs() != null && !pageEntity.getParagraphs().isEmpty()) {
                List<ParagraphsEntity> paragraphs = pageEntity.getParagraphs();
                paras = new ArrayList<>();

                for (ParagraphsEntity pe:paragraphs) {
                    Paragraph para = new Paragraph();
                    para.setBody(pe.getBody());
                    para.setHeader(pe.getHeader());
                    para.setImgUrl(pe.getImgUrl());
                    para.setParagraphId(pe.getParagraphId());

                    paras.add(para);
                }
            }

            page.setParagraphs(paras);

        }

        return page;
    }

    @Override
    public Integer addNewPage(Pages page) throws Exception {
        PagesEntity pagesEntity = new PagesEntity();
        pagesEntity.setHeader(page.getHeader());
        pagesEntity.setEdited(LocalDateTime.now());
        pagesEntity.setPosted(pagesEntity.getEdited());
        pagesEntity.setExcerpt(page.getExcerpt());

        List<ParagraphsEntity> paragraphsEntities = null;

        if (page.getParagraphs() != null && !page.getParagraphs().isEmpty()) {
            paragraphsEntities = new ArrayList<>();

            for (Paragraph p:page.getParagraphs()) {
                ParagraphsEntity pe = new ParagraphsEntity();
                pe.setBody(p.getBody());
                pe.setHeader(p.getHeader());
                pe.setImgUrl(p.getImgUrl());

                paragraphsEntities.add(pe);
            }
        }

        entityManager.persist(pagesEntity);

        pagesEntity.setParagraphs(paragraphsEntities);

        return pagesEntity.getPageId();
    }

    @Override
    public Pages editPage(Integer pageId, Pages page) throws Exception {
        PagesEntity pageEntity = entityManager.find(PagesEntity.class, pageId);

        if (pageEntity != null) {
            pageEntity.setEdited(LocalDateTime.now());
            pageEntity.setHeader(page.getHeader());
            pageEntity.setPosted(page.getPosted());
            pageEntity.setExcerpt(page.getExcerpt());

            List<ParagraphsEntity> paragraphsEntities = null;

            if (page.getParagraphs() != null && !page.getParagraphs().isEmpty()) {
                paragraphsEntities = new ArrayList<>();

                for (Paragraph p:page.getParagraphs()) {
                    ParagraphsEntity pe = new ParagraphsEntity();
                    pe.setBody(p.getBody());
                    pe.setHeader(p.getHeader());
                    pe.setImgUrl(p.getImgUrl());

                    paragraphsEntities.add(pe);
                }
            }

            entityManager.persist(pageEntity);

            pageEntity.setParagraphs(paragraphsEntities);

            page.setEdited(pageEntity.getEdited());

            return page;
        }

        return null;
    }

    @Override
    public Integer deletePage(Integer pageId) throws Exception {
        PagesEntity pageEntity = entityManager.find(PagesEntity.class, pageId);

        Pages page = null;
        if (pageEntity != null) {
            entityManager.remove(pageEntity);

            return pageEntity.getPageId();
        }

        return null;
    }
}
