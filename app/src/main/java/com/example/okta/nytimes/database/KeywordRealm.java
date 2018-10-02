package com.example.okta.nytimes.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class KeywordRealm extends RealmObject {
    @Required
    @PrimaryKey
    private Integer id;
    private String keyword;

    public Integer getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
