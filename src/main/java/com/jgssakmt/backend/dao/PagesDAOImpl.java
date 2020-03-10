package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.PagesEntity;
import com.jgssakmt.backend.entity.ParagraphsEntity;
import com.jgssakmt.backend.model.Pages;
import com.jgssakmt.backend.model.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PagesDAOImpl implements PagesDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Pages getPage(Integer pageId) throws Exception {
        Query query = entityManager.createQuery("select b from PagesEntity b where b.pageId = :pageId");
        query.setParameter("pageId", pageId);

        Pages page = null;
        List<PagesEntity> pageEntities = query.getResultList();

        if (!pageEntities.isEmpty()) {
            PagesEntity pageEntity = pageEntities.get(0);
            page = new Pages();
            page.setPageId(pageEntity.getPageId());
            page.setEdited(pageEntity.getEdited());
            page.setPosted(pageEntity.getPosted());
            page.setHeader(pageEntity.getHeader());

            List<Paragraph> paras = null;

            if (pageEntity.getParagraphs() != null && !pageEntity.getParagraphs().isEmpty()) {
                List<ParagraphsEntity> paragraphs = pageEntity.getParagraphs();

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

        pagesEntity.setParagraphs(paragraphsEntities);

        entityManager.persist(pagesEntity);

        return pagesEntity.getPageId();
    }

    @Override
    public Pages editPage(Integer pageId, Pages page) throws Exception {
        Query query = entityManager.createQuery("select b from PagesEntity b where b.pageId = :pageId");
        query.setParameter("pageId", pageId);

        List<PagesEntity> pageEntities = query.getResultList();

        if (!pageEntities.isEmpty()) {
            PagesEntity pageEntity = pageEntities.get(0);

            pageEntity.setEdited(LocalDateTime.now());
            pageEntity.setHeader(page.getHeader());
            pageEntity.setPosted(page.getPosted());

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

            pageEntity.setParagraphs(paragraphsEntities);

            entityManager.persist(pageEntity);

            page.setEdited(pageEntity.getEdited());

            return page;
        }

        return null;
    }

    @Override
    public Integer deletePage(Integer pageId) throws Exception {
        Query query = entityManager.createQuery("select b from PagesEntity b where b.pageId = :pageId");
        query.setParameter("pageId", pageId);

        List<PagesEntity> pageEntities = query.getResultList();

        if (!pageEntities.isEmpty()) {
            PagesEntity pageEntity = pageEntities.get(0);

            entityManager.remove(pageEntity);

            return pageEntity.getPageId();
        }

        return null;
    }
}
