
package com.example.okta.nytimes.model.search;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResponseSearchArticle {

    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("response")
    private Response mResponse;
    @SerializedName("status")
    private String mStatus;

    public String getCopyright() {
        return mCopyright;
    }

    public Response getResponse() {
        return mResponse;
    }

    public String getStatus() {
        return mStatus;
    }

    public static class Builder {

        private String mCopyright;
        private Response mResponse;
        private String mStatus;

        public ResponseSearchArticle.Builder withCopyright(String copyright) {
            mCopyright = copyright;
            return this;
        }

        public ResponseSearchArticle.Builder withResponse(Response response) {
            mResponse = response;
            return this;
        }

        public ResponseSearchArticle.Builder withStatus(String status) {
            mStatus = status;
            return this;
        }

        public ResponseSearchArticle build() {
            ResponseSearchArticle responseSearchArticle = new ResponseSearchArticle();
            responseSearchArticle.mCopyright = mCopyright;
            responseSearchArticle.mResponse = mResponse;
            responseSearchArticle.mStatus = mStatus;
            return responseSearchArticle;
        }

    }

}
