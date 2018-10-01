package com.example.okta.nytimes.ui.searcharticle;

import com.example.okta.nytimes.model.search.ResponseSearchArticle;

public interface SearchArticleView {
    void enterSearchView(String query);

    void showWait();

    void removeWait();

    void response(ResponseSearchArticle responseSearchArticle);

    void onFailure(String appErrorMessage);

    void responsenext(ResponseSearchArticle responseSearchArticle);
}
