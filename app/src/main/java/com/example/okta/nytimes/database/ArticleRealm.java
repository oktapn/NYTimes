package com.example.okta.nytimes.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ArticleRealm extends RealmObject{
    @Required
    @PrimaryKey
    private Integer article_id;
    private String imgurl;
    private String snippet;
    private String tgl;
    private String headline;

    public Integer getArticle_id() {
        return article_id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getTgl() {
        return tgl;
    }

    public String getHeadline() {
        return headline;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
