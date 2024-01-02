package com.example.androidass2;

import com.example.androidass2.javaClass.NewsHedlines;

import java.util.List;

public interface onfetchdatalistener<NewsApiResponse> {
    void onFetchData(List<NewsHedlines>list,String message);
    void onError(String message);
}
