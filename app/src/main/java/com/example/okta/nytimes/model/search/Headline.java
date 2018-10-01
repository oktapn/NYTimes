
package com.example.okta.nytimes.model.search;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Headline {

    @SerializedName("content_kicker")
    private Object mContentKicker;
    @SerializedName("kicker")
    private Object mKicker;
    @SerializedName("main")
    private String mMain;
    @SerializedName("name")
    private Object mName;
    @SerializedName("print_headline")
    private String mPrintHeadline;
    @SerializedName("seo")
    private Object mSeo;
    @SerializedName("sub")
    private Object mSub;

    public Object getContentKicker() {
        return mContentKicker;
    }

    public Object getKicker() {
        return mKicker;
    }

    public String getMain() {
        return mMain;
    }

    public Object getName() {
        return mName;
    }

    public String getPrintHeadline() {
        return mPrintHeadline;
    }

    public Object getSeo() {
        return mSeo;
    }

    public Object getSub() {
        return mSub;
    }

    public static class Builder {

        private Object mContentKicker;
        private Object mKicker;
        private String mMain;
        private Object mName;
        private String mPrintHeadline;
        private Object mSeo;
        private Object mSub;

        public Headline.Builder withContentKicker(Object contentKicker) {
            mContentKicker = contentKicker;
            return this;
        }

        public Headline.Builder withKicker(Object kicker) {
            mKicker = kicker;
            return this;
        }

        public Headline.Builder withMain(String main) {
            mMain = main;
            return this;
        }

        public Headline.Builder withName(Object name) {
            mName = name;
            return this;
        }

        public Headline.Builder withPrintHeadline(String printHeadline) {
            mPrintHeadline = printHeadline;
            return this;
        }

        public Headline.Builder withSeo(Object seo) {
            mSeo = seo;
            return this;
        }

        public Headline.Builder withSub(Object sub) {
            mSub = sub;
            return this;
        }

        public Headline build() {
            Headline headline = new Headline();
            headline.mContentKicker = mContentKicker;
            headline.mKicker = mKicker;
            headline.mMain = mMain;
            headline.mName = mName;
            headline.mPrintHeadline = mPrintHeadline;
            headline.mSeo = mSeo;
            headline.mSub = mSub;
            return headline;
        }

    }

}
