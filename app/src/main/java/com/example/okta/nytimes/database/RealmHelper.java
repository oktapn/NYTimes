package com.example.okta.nytimes.database;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    private static final String TAG = "RealmHelper";

    private Realm realm;
    private RealmResults<ArticleRealm> articleRealms;
    private RealmResults<KeywordRealm> keywordRealms;
    private Context context;

    public RealmHelper(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        this.context = context;
    }

    public void addArticle(String imgurl, String snippet, String tgl, String headline) {
        ArticleRealm articleRealm = new ArticleRealm();
        articleRealm.setArticle_id((int) setUniqueId());
        articleRealm.setImgurl(imgurl);
        articleRealm.setHeadline(headline);
        articleRealm.setSnippet(snippet);
        articleRealm.setTgl(tgl);
        if (realm.where(ArticleRealm.class).equalTo("headline", headline).count() == 0) {
            realm.beginTransaction();
            realm.copyToRealm(articleRealm);
            realm.commitTransaction();
            showLog("Added ; " + headline);
        } else {
            deleteDataArticle();
            showLog("Already in data ; " + headline);
        }
    }

    public ArrayList<Article> findAllArticle() {
        ArrayList<Article> data = new ArrayList<>();
        articleRealms = realm.where(ArticleRealm.class).findAll();
        if (articleRealms.size() > 0) {
            showLog("Size : " + articleRealms.size());
            for (int i = 0; i < articleRealms.size(); i++) {
                Integer article_id;
                String headline, snippet, imgurl, tgl;
                article_id = articleRealms.get(i).getArticle_id();
                headline = articleRealms.get(i).getHeadline();
                imgurl = articleRealms.get(i).getImgurl();
                snippet = articleRealms.get(i).getSnippet();
                tgl = articleRealms.get(i).getTgl();
                data.add(new Article(article_id, imgurl, snippet, tgl, headline));
            }
        } else {
            showLog("Size : 0");
        }
        return data;
    }

    public ArrayList<Keyword> findAllKeyword() {
        ArrayList<Keyword> data = new ArrayList<>();
        keywordRealms = realm.where(KeywordRealm.class).findAll();
        if (keywordRealms.size() > 0) {
            showLog("Size : " + keywordRealms.size());
            for (int i = 0; i < keywordRealms.size(); i++) {
                Integer id;
                String keyword;
                id = keywordRealms.get(i).getId();
                keyword = keywordRealms.get(i).getKeyword();
                data.add(new Keyword(id, keyword));
            }
        } else {
            showLog("Size : 0");
        }
        return data;
    }

    public void addKeyword(String keyword) {
        KeywordRealm keywordRealm = new KeywordRealm();
        keywordRealm.setId((int) setUniqueId());
        keywordRealm.setKeyword(keyword);
        if (realm.where(KeywordRealm.class).equalTo("keyword", keyword).count() == 0) {
            realm.beginTransaction();
            realm.copyToRealm(keywordRealm);
            realm.commitTransaction();
            showLog("Added ; " + keyword);
        } else {
            deleteDataArticle();
            showLog("Already in data ; " + keyword);
        }
    }

    private void showLog(String s) {
        Log.d(TAG, s);

    }

    public void deleteDataArticle() {
        realm.beginTransaction();
        realm.delete(ArticleRealm.class);
        realm.commitTransaction();

        showLog("Hapus data Article berhasil ");
    }

    public void deleteDataKeyword() {
        realm.beginTransaction();
        realm.delete(KeywordRealm.class);
        realm.commitTransaction();

        showLog("Hapus data Keyword berhasil ");
    }

    public long setUniqueId() {
        Number num = realm.where(ArticleRealm.class).max("article_id");
        if (num == null) return 1;
        else return ((long) num + 1);
    }
}
