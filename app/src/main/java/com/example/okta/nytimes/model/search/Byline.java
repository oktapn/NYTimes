
package com.example.okta.nytimes.model.search;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Byline {

    @SerializedName("organization")
    private String mOrganization;
    @SerializedName("original")
    private String mOriginal;
    @SerializedName("person")
    private List<Object> mPerson;

    public String getOrganization() {
        return mOrganization;
    }

    public String getOriginal() {
        return mOriginal;
    }

    public List<Object> getPerson() {
        return mPerson;
    }

    public static class Builder {

        private String mOrganization;
        private String mOriginal;
        private List<Object> mPerson;

        public Byline.Builder withOrganization(String organization) {
            mOrganization = organization;
            return this;
        }

        public Byline.Builder withOriginal(String original) {
            mOriginal = original;
            return this;
        }

        public Byline.Builder withPerson(List<Object> person) {
            mPerson = person;
            return this;
        }

        public Byline build() {
            Byline byline = new Byline();
            byline.mOrganization = mOrganization;
            byline.mOriginal = mOriginal;
            byline.mPerson = mPerson;
            return byline;
        }

    }

}
