package com.jgssakmt.backend.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PagesEntity {

    private String header;
    private Integer pageId;
    private List<ParagraphsEntity> paragraphs;
    private LocalDateTime posted;
    private LocalDateTime edited;

    public void setParagraphs(List<ParagraphsEntity> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

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
