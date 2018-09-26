package com.example.android.newsapp;

public class UserPreference {

    private String mArticleNumberPreference;
    private String mOrderByPreference;

    /**
     * Custom object to store user preferences from Settings
     *
     * @param articleNumberPreference number of news article per page
     * @param orderByPreference       sort news article in form of newest or relevance
     */
    public UserPreference(String articleNumberPreference
            , String orderByPreference) {

        mArticleNumberPreference = articleNumberPreference;
        mOrderByPreference = orderByPreference;
    }

    /**
     * @return news article per page
     */
    public String getArticleNumberPreference() {
        return mArticleNumberPreference;
    }

    /**
     * @return sort news by newest or relevance
     */
    public String getOrderByPreference() {
        return mOrderByPreference;
    }
}