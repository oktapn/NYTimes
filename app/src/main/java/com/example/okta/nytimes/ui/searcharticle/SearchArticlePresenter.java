package com.example.okta.nytimes.ui.searcharticle;

import android.view.View;
import android.widget.SearchView;

import com.example.okta.nytimes.R;
import com.example.okta.nytimes.model.search.ResponseSearchArticle;
import com.example.okta.nytimes.networking.NetworkError;
import com.example.okta.nytimes.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class SearchArticlePresenter {
    private final Service service;
    private final SearchArticleView view;
    private CompositeSubscription subscriptions;

    public SearchArticlePresenter(Service service, SearchArticleView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void setSearchView(final SearchView SWToolBar) {
        SWToolBar.setQueryHint("Keyword");
        SWToolBar.onActionViewExpanded();
        SWToolBar.setIconified(false);
        SWToolBar.clearFocus();
        SWToolBar.setActivated(true);
        SWToolBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                view.enterSearchView(query);
                SWToolBar.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        int searchId = SWToolBar.getResources().getIdentifier("android:id/search_plate", null, null);
        View v = SWToolBar.findViewById(searchId);
        v.setBackgroundResource(R.drawable.circlebuttonwhite);
    }

    public void getSearchArticle(String location, String page, String keyword, String apikey) {
        view.showWait();
        Subscription subscription = service.getSearchArticle(location, page, keyword, apikey, new Service.GetArticleSearchCallback() {
            @Override
            public void onSuccess(ResponseSearchArticle responseSearchArticle) {
                view.removeWait();
                view.response(responseSearchArticle);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }
        });
        subscriptions.add(subscription);
    }

    public void getSearchNextArticle(String location, String page, String keyword, String apikey) {
        Subscription subscription = service.getSearchArticle(location, page, keyword, apikey, new Service.GetArticleSearchCallback() {
            @Override
            public void onSuccess(ResponseSearchArticle responseSearchArticle) {
                view.responsenext(responseSearchArticle);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.onFailure(networkError.getAppErrorMessage());
            }
        });
        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }

}
