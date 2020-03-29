package com.jgssakmt.backend.model;

import java.time.LocalDateTime;
import java.util.List;

public class Pages {

    private String header;
    private Integer pageId;
    private List<Paragraph> paragraphs;
    private LocalDateTime posted;
    private LocalDateTime edited;
    private String excerpt;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
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

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
}
