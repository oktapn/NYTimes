
package com.example.okta.nytimes.model.search;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Doc {

    @SerializedName("blog")
    private Blog mBlog;
    @SerializedName("byline")
    private Byline mByline;
    @SerializedName("document_type")
    private String mDocumentType;
    @SerializedName("headline")
    private Headline mHeadline;
    @SerializedName("keywords")
    private List<Keyword> mKeywords;
    @SerializedName("multimedia")
    private List<Multimedium> mMultimedia;
    @SerializedName("news_desk")
    private String mNewsDesk;
    @SerializedName("pub_date")
    private String mPubDate;
    @SerializedName("score")
    private Double mScore;
    @SerializedName("section_name")
    private String mSectionName;
    @SerializedName("snippet")
    private String mSnippet;
    @SerializedName("source")
    private String mSource;
    @SerializedName("type_of_material")
    private String mTypeOfMaterial;
    @SerializedName("uri")
    private String mUri;
    @SerializedName("web_url")
    private String mWebUrl;
    @SerializedName("word_count")
    private Long mWordCount;
    @SerializedName("_id")
    private String m_id;

    public Blog getBlog() {
        return mBlog;
    }

    public Byline getByline() {
        return mByline;
    }

    public String getDocumentType() {
        return mDocumentType;
    }

    public Headline getHeadline() {
        return mHeadline;
    }

    public List<Keyword> getKeywords() {
        return mKeywords;
    }

    public List<Multimedium> getMultimedia() {
        return mMultimedia;
    }

    public String getNewsDesk() {
        return mNewsDesk;
    }

    public String getPubDate() {
        return mPubDate;
    }

    public Double getScore() {
        return mScore;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getSnippet() {
        return mSnippet;
    }

    public String getSource() {
        return mSource;
    }

    public String getTypeOfMaterial() {
        return mTypeOfMaterial;
    }

    public String getUri() {
        return mUri;
    }

    public String getWebUrl() {
        return mWebUrl;
    }

    public Long getWordCount() {
        return mWordCount;
    }

    public String get_id() {
        return m_id;
    }

    public static class Builder {

        private Blog mBlog;
        private Byline mByline;
        private String mDocumentType;
        private Headline mHeadline;
        private List<Keyword> mKeywords;
        private List<Multimedium> mMultimedia;
        private String mNewsDesk;
        private String mPubDate;
        private Double mScore;
        private String mSectionName;
        private String mSnippet;
        private String mSource;
        private String mTypeOfMaterial;
        private String mUri;
        private String mWebUrl;
        private Long mWordCount;
        private String m_id;

        public Doc.Builder withBlog(Blog blog) {
            mBlog = blog;
            return this;
        }

        public Doc.Builder withByline(Byline byline) {
            mByline = byline;
            return this;
        }

        public Doc.Builder withDocumentType(String documentType) {
            mDocumentType = documentType;
            return this;
        }

        public Doc.Builder withHeadline(Headline headline) {
            mHeadline = headline;
            return this;
        }

        public Doc.Builder withKeywords(List<Keyword> keywords) {
            mKeywords = keywords;
            return this;
        }

        public Doc.Builder withMultimedia(List<Multimedium> multimedia) {
            mMultimedia = multimedia;
            return this;
        }

        public Doc.Builder withNewsDesk(String newsDesk) {
            mNewsDesk = newsDesk;
            return this;
        }

        public Doc.Builder withPubDate(String pubDate) {
            mPubDate = pubDate;
            return this;
        }

        public Doc.Builder withScore(Double score) {
            mScore = score;
            return this;
        }

        public Doc.Builder withSectionName(String sectionName) {
            mSectionName = sectionName;
            return this;
        }

        public Doc.Builder withSnippet(String snippet) {
            mSnippet = snippet;
            return this;
        }

        public Doc.Builder withSource(String source) {
            mSource = source;
            return this;
        }

        public Doc.Builder withTypeOfMaterial(String typeOfMaterial) {
            mTypeOfMaterial = typeOfMaterial;
            return this;
        }

        public Doc.Builder withUri(String uri) {
            mUri = uri;
            return this;
        }

        public Doc.Builder withWebUrl(String webUrl) {
            mWebUrl = webUrl;
            return this;
        }

        public Doc.Builder withWordCount(Long wordCount) {
            mWordCount = wordCount;
            return this;
        }

        public Doc.Builder with_id(String _id) {
            m_id = _id;
            return this;
        }

        public Doc build() {
            Doc doc = new Doc();
            doc.mBlog = mBlog;
            doc.mByline = mByline;
            doc.mDocumentType = mDocumentType;
            doc.mHeadline = mHeadline;
            doc.mKeywords = mKeywords;
            doc.mMultimedia = mMultimedia;
            doc.mNewsDesk = mNewsDesk;
            doc.mPubDate = mPubDate;
            doc.mScore = mScore;
            doc.mSectionName = mSectionName;
            doc.mSnippet = mSnippet;
            doc.mSource = mSource;
            doc.mTypeOfMaterial = mTypeOfMaterial;
            doc.mUri = mUri;
            doc.mWebUrl = mWebUrl;
            doc.mWordCount = mWordCount;
            doc.m_id = m_id;
            return doc;
        }

    }

}
