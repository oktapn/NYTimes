
package com.example.okta.nytimes.model.mostviewed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("abstract")
    private String mAbstract;
    @SerializedName("adx_keywords")
    private String mAdxKeywords;
    @SerializedName("asset_id")
    private Long mAssetId;
    @SerializedName("byline")
    private String mByline;
    @SerializedName("column")
    private String mColumn;
    @SerializedName("des_facet")
    private String mDesFacet;
    @SerializedName("geo_facet")
    private String mGeoFacet;
    @SerializedName("id")
    private Long mId;
    @SerializedName("media")
    private List<Medium> mMedia;
    @SerializedName("org_facet")
    private String mOrgFacet;
    @SerializedName("per_facet")
    private List<String> mPerFacet;
    @SerializedName("published_date")
    private String mPublishedDate;
    @SerializedName("section")
    private String mSection;
    @SerializedName("source")
    private String mSource;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("views")
    private Long mViews;

    public String getAbstract() {
        return mAbstract;
    }

    public void setAbstract(String abstracts) {
        mAbstract = abstracts;
    }

    public String getAdxKeywords() {
        return mAdxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        mAdxKeywords = adxKeywords;
    }

    public Long getAssetId() {
        return mAssetId;
    }

    public void setAssetId(Long assetId) {
        mAssetId = assetId;
    }

    public String getByline() {
        return mByline;
    }

    public void setByline(String byline) {
        mByline = byline;
    }

    public String getColumn() {
        return mColumn;
    }

    public void setColumn(String column) {
        mColumn = column;
    }

    public String getDesFacet() {
        return mDesFacet;
    }

    public void setDesFacet(String desFacet) {
        mDesFacet = desFacet;
    }

    public String getGeoFacet() {
        return mGeoFacet;
    }

    public void setGeoFacet(String geoFacet) {
        mGeoFacet = geoFacet;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Medium> getMedia() {
        return mMedia;
    }

    public void setMedia(List<Medium> media) {
        mMedia = media;
    }

    public String getOrgFacet() {
        return mOrgFacet;
    }

    public void setOrgFacet(String orgFacet) {
        mOrgFacet = orgFacet;
    }

    public List<String> getPerFacet() {
        return mPerFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        mPerFacet = perFacet;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        mPublishedDate = publishedDate;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Long getViews() {
        return mViews;
    }

    public void setViews(Long views) {
        mViews = views;
    }

}
