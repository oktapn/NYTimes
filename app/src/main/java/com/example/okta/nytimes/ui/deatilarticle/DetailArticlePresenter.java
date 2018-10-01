package com.example.okta.nytimes.ui.deatilarticle;

public class DetailArticlePresenter {
    private final DetailArticleView view;

    public DetailArticlePresenter(DetailArticleView view) {
        this.view = view;
    }

    public void setViewDetail(String imgurl, String tgl, String headline, String snippet) {
        view.setDetail(imgurl, tgl, headline, snippet);
    }

}
