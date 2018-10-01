package com.example.okta.nytimes.networking;


import com.example.okta.nytimes.model.mostviewed.ResponseMostViwed;
import com.example.okta.nytimes.model.search.ResponseSearchArticle;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkService {

    @GET("svc/search/v2/articlesearch.json")
    Observable<ResponseSearchArticle> getArticleBysearch(@Query("q") String location,
                                                         @Query("page") String page,
                                                         @Query("fq") String keyword,
                                                         @Query("api-key") String apikey);

    @GET("mostviewed/{section}/{time-period}.json")
    Observable<ResponseMostViwed> getMostViewed(@Path("sectio") String section,
                                                @Path("time-period") String timeperiod);
}
