package com.jgssakmt.backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pages")
public class PagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pageId;
    private String header;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "page_id")
    private List<ParagraphsEntity> paragraphs;
    private String excerpt;
    private LocalDateTime posted;
    private LocalDateTime edited;
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
