package com.example.androidass2;

import android.content.Context;
import android.widget.Toast;

import com.example.androidass2.javaClass.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ManegerRequestCoin {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public  void getNewsHeadlines(onfetchdatalistener listener ,String category,String query ){
        CallNewsApi callNewsApi = retrofit.create(CallNewsApi.class);
        Call<NewsApiResponse> call = callNewsApi.callhealines("",category ,"bitcoin",context.getString(R.string.api_Key));

        try{
            call.enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                    if (response != null) {
                        if (response.isSuccessful() && response.body() != null) {
                            listener.onFetchData(response.body().getArticles(), response.message());
                        } else {
                            String errorMessage = "Unsuccessful response: " + response.message();
                            listener.onError(errorMessage);
                        }
                    } else {
                        listener.onError("Null response");
                    }
                }


                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                    listener.onError("Request Failed!!");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ManegerRequestCoin(Context context) {
        this.context = context;
    }
    public  interface CallNewsApi {
        @GET("everything")
        Call<NewsApiResponse> callhealines(
                @Query("title") String title,
                @Query("description") String description,
                @Query("q") String query,
                @Query("apiKey") String apiKey
        );
    }}

