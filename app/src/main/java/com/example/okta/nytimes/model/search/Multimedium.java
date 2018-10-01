
package com.example.okta.nytimes.model.search;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Multimedium {

    @SerializedName("caption")
    private Object mCaption;
    @SerializedName("credit")
    private Object mCredit;
    @SerializedName("crop_name")
    private String mCropName;
    @SerializedName("height")
    private Long mHeight;
    @SerializedName("legacy")
    private Legacy mLegacy;
    @SerializedName("rank")
    private Long mRank;
    @SerializedName("subType")
    private String mSubType;
    @SerializedName("subtype")
    private String mSubtype;
    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("width")
    private Long mWidth;

    public Object getCaption() {
        return mCaption;
    }

    public Object getCredit() {
        return mCredit;
    }

    public String getCropName() {
        return mCropName;
    }

    public Long getHeight() {
        return mHeight;
    }

    public Legacy getLegacy() {
        return mLegacy;
    }

    public Long getRank() {
        return mRank;
    }

    public String getSubType() {
        return mSubType;
    }

    public String getSubtype() {
        return mSubtype;
    }

    public String getType() {
        return mType;
    }

    public String getUrl() {
        return mUrl;
    }

    public Long getWidth() {
        return mWidth;
    }

    public static class Builder {

        private Object mCaption;
        private Object mCredit;
        private String mCropName;
        private Long mHeight;
        private Legacy mLegacy;
        private Long mRank;
        private String mSubType;
        private String mSubtype;
        private String mType;
        private String mUrl;
        private Long mWidth;

        public Multimedium.Builder withCaption(Object caption) {
            mCaption = caption;
            return this;
        }

        public Multimedium.Builder withCredit(Object credit) {
            mCredit = credit;
            return this;
        }

        public Multimedium.Builder withCropName(String cropName) {
            mCropName = cropName;
            return this;
        }

        public Multimedium.Builder withHeight(Long height) {
            mHeight = height;
            return this;
        }

        public Multimedium.Builder withLegacy(Legacy legacy) {
            mLegacy = legacy;
            return this;
        }

        public Multimedium.Builder withRank(Long rank) {
            mRank = rank;
            return this;
        }

        public Multimedium.Builder withSubType(String subType) {
            mSubType = subType;
            return this;
        }

        public Multimedium.Builder withSubtype(String subtype) {
            mSubtype = subtype;
            return this;
        }

        public Multimedium.Builder withType(String type) {
            mType = type;
            return this;
        }

        public Multimedium.Builder withUrl(String url) {
            mUrl = url;
            return this;
        }

        public Multimedium.Builder withWidth(Long width) {
            mWidth = width;
            return this;
        }

        public Multimedium build() {
            Multimedium multimedium = new Multimedium();
            multimedium.mCaption = mCaption;
            multimedium.mCredit = mCredit;
            multimedium.mCropName = mCropName;
            multimedium.mHeight = mHeight;
            multimedium.mLegacy = mLegacy;
            multimedium.mRank = mRank;
            multimedium.mSubType = mSubType;
            multimedium.mSubtype = mSubtype;
            multimedium.mType = mType;
            multimedium.mUrl = mUrl;
            multimedium.mWidth = mWidth;
            return multimedium;
        }

    }

}
