package com.jgssakmt.backend.model;

import java.util.List;

public class Pages {

    private String header;
    private Integer pageId;
    private List<Paragraph> paragraphs;

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

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
}
