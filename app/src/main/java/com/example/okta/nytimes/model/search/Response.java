
package com.example.okta.nytimes.model.search;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Response {

    @SerializedName("docs")
    private List<Doc> mDocs;
    @SerializedName("meta")
    private Meta mMeta;

    public List<Doc> getDocs() {
        return mDocs;
    }

    public Meta getMeta() {
        return mMeta;
    }

    public static class Builder {

        private List<Doc> mDocs;
        private Meta mMeta;

        public Response.Builder withDocs(List<Doc> docs) {
            mDocs = docs;
            return this;
        }

        public Response.Builder withMeta(Meta meta) {
            mMeta = meta;
            return this;
        }

        public Response build() {
            Response response = new Response();
            response.mDocs = mDocs;
            response.mMeta = mMeta;
            return response;
        }

    }

}
