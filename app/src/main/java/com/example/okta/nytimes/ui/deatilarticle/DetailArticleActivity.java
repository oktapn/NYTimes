package com.example.okta.nytimes.ui.deatilarticle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.okta.nytimes.BaseApp;
import com.example.okta.nytimes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailArticleActivity extends BaseApp implements DetailArticleView {

    @BindView(R.id.TitleDetail)
    TextView TitleDetail;
    @BindView(R.id.ImageDetail)
    ImageView ImageDetail;
    @BindView(R.id.DateDetail)
    TextView DateDetail;
    @BindView(R.id.DescriptionDetail)
    TextView DescriptionDetail;
    ProgressDialog pd;
    DetailArticlePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);
        ButterKnife.bind(this);
        getDeps().inject(this);
        pd = new ProgressDialog(this, R.style.MyTheme);
        presenter = new DetailArticlePresenter(this);
        getIntentData();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        String API_IMAGE_BASE_URL = "http://www.nytimes.com/";
        String imgurl = API_IMAGE_BASE_URL + (String) bd.get("imgurl");
        String snippet = (String) bd.get("snippet");
        String tgl = (String) bd.get("tgl");
        String headline = (String) bd.get("headline");
        presenter.setViewDetail(imgurl, tgl, headline, snippet);
    }

    @Override
    public void setDetail(String imgurl, String tgl, String headline, String snippet) {
        TitleDetail.setText(headline);
        DateDetail.setText(tgl);
        DescriptionDetail.setText(snippet);
        Glide.with(getApplicationContext()).load(imgurl).placeholder(R.color.greytoblack).into(ImageDetail);
    }
}
