package com.example.okta.nytimes.ui.main;

import com.example.okta.nytimes.model.search.ResponseSearchArticle;

public interface MainView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void response(ResponseSearchArticle responseSearchArticle);

    void responsenext(ResponseSearchArticle responseSearchArticle);
}
