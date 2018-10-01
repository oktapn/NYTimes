package com.example.okta.nytimes.deps;

import com.example.okta.nytimes.networking.NetworkModule;
import com.example.okta.nytimes.ui.deatilarticle.DetailArticleActivity;
import com.example.okta.nytimes.ui.main.MainActivity;
import com.example.okta.nytimes.ui.searcharticle.SearchArticleActivity;
import com.example.okta.nytimes.ui.splashscreen.SplashscreenActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(DetailArticleActivity detailArticleActivity);

    void inject(SearchArticleActivity searchArticleActivity);

    void inject(MainActivity mainActivity);

    void inject(SplashscreenActivity splashscreenActivity);

}
