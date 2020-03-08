package com.jgssakmt.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class BlogsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer blogId;
    private String title;
    private String content;
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}
