package com.example.okta.nytimes.networking;

import com.example.okta.nytimes.model.mostviewed.ResponseMostViwed;
import com.example.okta.nytimes.model.search.ResponseSearchArticle;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Service {

    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getSearchArticle(String location, String page, String keyword, String apikey, final GetArticleSearchCallback getArticleSearchCallback) {
        return networkService.getArticleBysearch(location, page, keyword,apikey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ResponseSearchArticle>>() {
                    @Override
                    public Observable<? extends ResponseSearchArticle> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ResponseSearchArticle>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getArticleSearchCallback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(ResponseSearchArticle responseSearchArticle) {
                        getArticleSearchCallback.onSuccess(responseSearchArticle);
                    }
                });
    }

    public interface GetArticleSearchCallback {
        void onSuccess(ResponseSearchArticle responseSearchArticle);

        void onError(NetworkError networkError);
    }

    public Subscription getMostviwedArticle(String section, String timeperiod, final GetArticleMostViewedCallback getArticleMostViewedCallback) {
        return networkService.getMostViewed(section, timeperiod)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ResponseMostViwed>>() {
                    @Override
                    public Observable<? extends ResponseMostViwed> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ResponseMostViwed>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getArticleMostViewedCallback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(ResponseMostViwed responseMostViwed) {
                        getArticleMostViewedCallback.onSuccess(responseMostViwed);
                    }
                });
    }

    public interface GetArticleMostViewedCallback {
        void onSuccess(ResponseMostViwed responseSearchArticle);

        void onError(NetworkError networkError);
    }
}
