package com.jgssakmt.backend.model;

public class Paragraph implements Comparable<Paragraph> {

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

    @Override
    public int compareTo(Paragraph o) {
        return this.getParagraphId().compareTo(o.getParagraphId());
    }
}
