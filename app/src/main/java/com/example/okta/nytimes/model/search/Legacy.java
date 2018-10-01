
package com.example.okta.nytimes.model.search;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Legacy {

    @SerializedName("xlarge")
    private String mXlarge;
    @SerializedName("xlargeheight")
    private Long mXlargeheight;
    @SerializedName("xlargewidth")
    private Long mXlargewidth;

    public String getXlarge() {
        return mXlarge;
    }

    public Long getXlargeheight() {
        return mXlargeheight;
    }

    public Long getXlargewidth() {
        return mXlargewidth;
    }

    public static class Builder {

        private String mXlarge;
        private Long mXlargeheight;
        private Long mXlargewidth;

        public Legacy.Builder withXlarge(String xlarge) {
            mXlarge = xlarge;
            return this;
        }

        public Legacy.Builder withXlargeheight(Long xlargeheight) {
            mXlargeheight = xlargeheight;
            return this;
        }

        public Legacy.Builder withXlargewidth(Long xlargewidth) {
            mXlargewidth = xlargewidth;
            return this;
        }

        public Legacy build() {
            Legacy legacy = new Legacy();
            legacy.mXlarge = mXlarge;
            legacy.mXlargeheight = mXlargeheight;
            legacy.mXlargewidth = mXlargewidth;
            return legacy;
        }

    }

}
