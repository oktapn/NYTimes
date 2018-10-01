
package com.example.okta.nytimes.model.mostviewed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Medium {

    @SerializedName("approved_for_syndication")
    private Long mApprovedForSyndication;
    @SerializedName("caption")
    private Object mCaption;
    @SerializedName("copyright")
    private Object mCopyright;
    @SerializedName("media-metadata")
    private List<MediaMetadatum> mMediaMetadata;
    @SerializedName("subtype")
    private String mSubtype;
    @SerializedName("type")
    private String mType;

    public Long getApprovedForSyndication() {
        return mApprovedForSyndication;
    }

    public void setApprovedForSyndication(Long approvedForSyndication) {
        mApprovedForSyndication = approvedForSyndication;
    }

    public Object getCaption() {
        return mCaption;
    }

    public void setCaption(Object caption) {
        mCaption = caption;
    }

    public Object getCopyright() {
        return mCopyright;
    }

    public void setCopyright(Object copyright) {
        mCopyright = copyright;
    }

    public List<MediaMetadatum> getMediaMetadata() {
        return mMediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        mMediaMetadata = mediaMetadata;
    }

    public String getSubtype() {
        return mSubtype;
    }

    public void setSubtype(String subtype) {
        mSubtype = subtype;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
