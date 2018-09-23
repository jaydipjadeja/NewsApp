package com.example.android.newsapp;

public class News {

    // News title
    private String mNewsTitle;

    // News section
    private String mSection;

    // News image url
    private String mImageUrl;

    //News time
    private String mNewsTime;

    //News Detail Url
    private String mWebUrl;

    public News(String title, String section, String imageUrl, String time, String webUrl){
        mNewsTitle = title;
        mSection = section;
        mImageUrl = imageUrl;
        mNewsTime = time;
        mWebUrl = webUrl;
    }

    public String getNewsTitle() {
        return mNewsTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String  getNewsTime() {
        return mNewsTime;
    }

    public String getWebUrl() {
        return mWebUrl;
    }
}
