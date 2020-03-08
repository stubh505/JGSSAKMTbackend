package com.jgssakmt.backend.entity;

import java.util.List;

public class PagesEntity {

    private String header;
    private Integer pageId;
    private List<ParagraphsEntity> paragraphs;

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<ParagraphsEntity> getParagraphs() {
        return paragraphs;
    }
}
