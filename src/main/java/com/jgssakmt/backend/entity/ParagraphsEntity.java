package com.jgssakmt.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "paragraphs")
public class ParagraphsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paragraphId;
    private String header;
    private String body;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getParagraphId() {
        return paragraphId;
    }

    public void setParagraphId(Integer paragraphId) {
        this.paragraphId = paragraphId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
