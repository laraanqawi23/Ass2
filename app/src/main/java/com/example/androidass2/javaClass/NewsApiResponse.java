package com.example.androidass2.javaClass;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponse implements Serializable {
    String status;
    int totalResult;
    List<NewsHedlines> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public List<NewsHedlines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHedlines> articles) {
        this.articles = articles;
    }
}
