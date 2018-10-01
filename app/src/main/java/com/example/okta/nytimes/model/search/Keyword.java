
package com.example.okta.nytimes.model.search;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Keyword {

    @SerializedName("major")
    private String mMajor;
    @SerializedName("name")
    private String mName;
    @SerializedName("rank")
    private Long mRank;
    @SerializedName("value")
    private String mValue;

    public String getMajor() {
        return mMajor;
    }

    public String getName() {
        return mName;
    }

    public Long getRank() {
        return mRank;
    }

    public String getValue() {
        return mValue;
    }

    public static class Builder {

        private String mMajor;
        private String mName;
        private Long mRank;
        private String mValue;

        public Keyword.Builder withMajor(String major) {
            mMajor = major;
            return this;
        }

        public Keyword.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Keyword.Builder withRank(Long rank) {
            mRank = rank;
            return this;
        }

        public Keyword.Builder withValue(String value) {
            mValue = value;
            return this;
        }

        public Keyword build() {
            Keyword keyword = new Keyword();
            keyword.mMajor = mMajor;
            keyword.mName = mName;
            keyword.mRank = mRank;
            keyword.mValue = mValue;
            return keyword;
        }

    }

}
