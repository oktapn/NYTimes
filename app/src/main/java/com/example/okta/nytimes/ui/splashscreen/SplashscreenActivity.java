package com.example.okta.nytimes.ui.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.okta.nytimes.BaseApp;
import com.example.okta.nytimes.R;
import com.example.okta.nytimes.ui.main.MainActivity;

import butterknife.ButterKnife;

public class SplashscreenActivity extends BaseApp implements SplashscreenView{

    SplashscreenPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ButterKnife.bind(this);
        getDeps().inject(this);
        presenter = new SplashscreenPresenter(this);
        presenter.checkAccount();
    }

    @Override
    public void finishActivity() {
        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
