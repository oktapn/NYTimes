package com.example.okta.nytimes.ui.main;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.okta.nytimes.BaseApp;
import com.example.okta.nytimes.BuildConfig;
import com.example.okta.nytimes.R;
import com.example.okta.nytimes.adapter.RVListArticle;
import com.example.okta.nytimes.adapter.RVListArticleDatabase;
import com.example.okta.nytimes.database.Article;
import com.example.okta.nytimes.database.RealmHelper;
import com.example.okta.nytimes.model.search.ResponseSearchArticle;
import com.example.okta.nytimes.networking.Service;
import com.example.okta.nytimes.ui.searcharticle.SearchArticleActivity;
import com.example.okta.nytimes.widget.EndlessRecyclerOnScrollListener;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseApp implements MainView {

    @BindView(R.id.RVArticle)
    RecyclerView mRecyclerView;
    @Inject
    public Service service;
    MainPresenter presenter;
    ProgressDialog pd;
    RVListArticle mAdapater;
    RVListArticleDatabase mAdapaterDatabase;
    LinearLayoutManager mLayoutManager;
    private RealmHelper helper;
    private ArrayList<Article> articles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getDeps().inject(this);
        helper = new RealmHelper(this);
        articles = new ArrayList<>();
        presenter = new MainPresenter(service, this);
        pd = new ProgressDialog(this, R.style.MyTheme);
        presenter.isConnected(this);
    }

    @OnClick(R.id.SearchIcon)
    void opensearch() {
        Intent searchIntent = new Intent(this, SearchArticleActivity.class);
        startActivity(searchIntent);
    }

    @Override
    public void showWait() {
        pd.setCancelable(false);
        pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        pd.show();
    }

    @Override
    public void removeWait() {
        pd.dismiss();
    }

    @Override
    public void onFailure(String appErrorMessage) {
        Toast.makeText(getApplicationContext(), appErrorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void response(ResponseSearchArticle responseSearchArticle) {
        for (int i =0 ; i<responseSearchArticle.getResponse().getDocs().size();i++){
            helper.addArticle(
                    responseSearchArticle.getResponse().getDocs().get(i).getMultimedia().size() != 0 ? responseSearchArticle.getResponse().getDocs().get(i).getMultimedia().get(0).getUrl() : "-",
                    responseSearchArticle.getResponse().getDocs().get(i).getSnippet(),
                    responseSearchArticle.getResponse().getDocs().get(i).getPubDate() == null ? " " : getDateMonthParsefromString(responseSearchArticle.getResponse().getDocs().get(i).getPubDate()),
                    responseSearchArticle.getResponse().getDocs().get(i).getHeadline().getMain());
        }
        mAdapater = new RVListArticle();
        mAdapater.setContentItems(responseSearchArticle.getResponse().getDocs());
        mAdapater.notifyDataSetChanged();
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapater);
        mLayoutManager.setSmoothScrollbarEnabled(true);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                if (responseSearchArticle.getResponse().getDocs().size() >= 10) {
                    responseSearchArticle.getResponse().getDocs().add(null);
                    mAdapater.notifyItemInserted(responseSearchArticle.getResponse().getDocs().size() - 1);
                    new Handler().postDelayed(() -> {
                        responseSearchArticle.getResponse().getDocs().remove(responseSearchArticle.getResponse().getDocs().size() - 1);
                        mAdapater.notifyItemRemoved(responseSearchArticle.getResponse().getDocs().size());
                        int pagebytotal = mAdapater.getItemCount();
                        presenter.getMostViewedNextArticle("indonesia", String.valueOf(pagebytotal / 10 + 1), "", BuildConfig.KEYAPI);
                    }, 2000);
                }
            }
        });
    }

    @Override
    public void responsenext(ResponseSearchArticle responseSearchArticle) {
        if (responseSearchArticle.getResponse().getDocs().size() != 0) {
            for (int i = 0; i < 10; i++) {
                mAdapater.addItem(responseSearchArticle.getResponse().getDocs().get(i), mAdapater.getItemCount());
            }
        }
        if (mAdapater.getItemCount() < responseSearchArticle.getResponse().getDocs().size()) {
            Integer Pagecoma = responseSearchArticle.getResponse().getDocs().size() % 10;
            if (Pagecoma != 0) {
                for (int i = 0; i < Pagecoma; i++) {
                    mAdapater.addItem(responseSearchArticle.getResponse().getDocs().get(i), mAdapater.getItemCount());
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    mAdapater.addItem(responseSearchArticle.getResponse().getDocs().get(i), mAdapater.getItemCount());
                }
            }
        }
        mAdapater.notifyDataSetChanged();
    }

    private String getDateMonthParsefromString(String date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat mdformat = new SimpleDateFormat("EEEE , dd-MM-yyyy", new java.util.Locale("id"));
        return mdformat.format(myDate);
    }

    @Override
    public void ifconnected() {
        presenter.getMostViewedArticle("indonesia", "1", "", BuildConfig.KEYAPI);
    }

    @Override
    public void ifnotconnected() {
        articles = helper.findAllArticle();
        if (articles != null) {
            mAdapaterDatabase = new RVListArticleDatabase();
            mAdapaterDatabase.setContentItems(articles);
            mAdapaterDatabase.notifyDataSetChanged();
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapaterDatabase);
            mLayoutManager.setSmoothScrollbarEnabled(true);
            mRecyclerView.setHasFixedSize(true);
        } else {
            Toast.makeText(getApplicationContext(), "Data Belum ada Tersimpan", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }
}
