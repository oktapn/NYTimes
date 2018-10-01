package com.example.okta.nytimes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.okta.nytimes.deps.DaggerDeps;
import com.example.okta.nytimes.deps.Deps;
import com.example.okta.nytimes.networking.NetworkModule;

import java.io.File;

/**
 * Modified by okta on 9/30/18.
 */
public class BaseApp extends AppCompatActivity {
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}
