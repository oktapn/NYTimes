package com.example.okta.nytimes.ui.main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.okta.nytimes.model.search.ResponseSearchArticle;
import com.example.okta.nytimes.networking.NetworkError;
import com.example.okta.nytimes.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MainPresenter {
    private final Service service;
    private final MainView view;
    private CompositeSubscription subscriptions;

    public MainPresenter(Service service, MainView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }


    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiInfo != null && wifiInfo.isConnected()) || (mobileInfo != null && mobileInfo.isConnected())) {
            view.ifconnected();
            return true;
        } else {
            view.ifnotconnected();
            return false;
        }
    }

    public void getMostViewedArticle(String location, String page, String keyword, String apikey) {
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

    public void getMostViewedNextArticle(String location, String page, String keyword, String apikey) {
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
