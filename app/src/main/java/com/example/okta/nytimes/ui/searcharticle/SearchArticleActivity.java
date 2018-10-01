package com.example.okta.nytimes.ui.searcharticle;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.okta.nytimes.BaseApp;
import com.example.okta.nytimes.BuildConfig;
import com.example.okta.nytimes.R;
import com.example.okta.nytimes.adapter.RVListArticle;
import com.example.okta.nytimes.adapter.RVListArticleSearch;
import com.example.okta.nytimes.model.search.ResponseSearchArticle;
import com.example.okta.nytimes.networking.Service;
import com.example.okta.nytimes.ui.main.MainPresenter;
import com.example.okta.nytimes.widget.EndlessRecyclerOnScrollListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchArticleActivity extends BaseApp implements SearchArticleView {

    @BindView(R.id.RVResultSearch)
    RecyclerView mRecyclerView;
    @BindView(R.id.SWToolBar)
    SearchView SWToolBar;
    @Inject
    public Service service;
    SearchArticlePresenter presenter;
    ProgressDialog pd;
    RVListArticleSearch mAdapater;
    LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_article);
        ButterKnife.bind(this);
        getDeps().inject(this);
        presenter = new SearchArticlePresenter(service, this);
        pd = new ProgressDialog(this, R.style.MyTheme);
        presenter.setSearchView(SWToolBar);
    }

    @Override
    public void enterSearchView(String query) {
        presenter.getSearchArticle("indonesia", "1", query, BuildConfig.KEYAPI);
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
    public void response(ResponseSearchArticle responseSearchArticle) {
        mAdapater = new RVListArticleSearch();
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
                        presenter.getSearchNextArticle("indonesia", String.valueOf(pagebytotal / 10 + 1), SWToolBar.getQuery().toString(), BuildConfig.KEYAPI);
                    }, 2000);
                }
            }
        });
    }

    @Override
    public void onFailure(String appErrorMessage) {
        Toast.makeText(getApplicationContext(), appErrorMessage, Toast.LENGTH_LONG).show();
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

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }
}
