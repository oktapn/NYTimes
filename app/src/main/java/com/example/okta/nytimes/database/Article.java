package com.example.okta.nytimes.database;

public class Article {
    private Integer article_id;
    private String imgurl;
    private String snippet;
    private String tgl;
    private String headline;

    public Article(Integer article_id, String imgurl, String snippet, String tgl, String headline) {
        this.article_id = article_id;
        this.imgurl = imgurl;
        this.snippet = snippet;
        this.tgl = tgl;
        this.headline = headline;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
