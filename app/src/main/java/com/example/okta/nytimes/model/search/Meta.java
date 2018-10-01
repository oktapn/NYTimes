
package com.example.okta.nytimes.model.search;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Meta {

    @SerializedName("hits")
    private Long mHits;
    @SerializedName("offset")
    private Long mOffset;
    @SerializedName("time")
    private Long mTime;

    public Long getHits() {
        return mHits;
    }

    public Long getOffset() {
        return mOffset;
    }

    public Long getTime() {
        return mTime;
    }

    public static class Builder {

        private Long mHits;
        private Long mOffset;
        private Long mTime;

        public Meta.Builder withHits(Long hits) {
            mHits = hits;
            return this;
        }

        public Meta.Builder withOffset(Long offset) {
            mOffset = offset;
            return this;
        }

        public Meta.Builder withTime(Long time) {
            mTime = time;
            return this;
        }

        public Meta build() {
            Meta meta = new Meta();
            meta.mHits = mHits;
            meta.mOffset = mOffset;
            meta.mTime = mTime;
            return meta;
        }

    }

}
