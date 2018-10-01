package com.example.okta.nytimes.ui.splashscreen;

import android.os.Handler;

public class SplashscreenPresenter {
    private final SplashscreenView view;

    public SplashscreenPresenter(SplashscreenView view) {
        this.view = view;
    }

    public void checkAccount() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               view.finishActivity();
            }
        }, 2000);
    }
}
