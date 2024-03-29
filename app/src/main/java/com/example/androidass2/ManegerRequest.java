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

public class ManegerRequest {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    public  void getNewsHeadlines(onfetchdatalistener listener ,String category,String query ){
        CallNewsApi callNewsApi = retrofit.create(CallNewsApi.class);
        Call<NewsApiResponse> call = callNewsApi.callhealines("us",category ,query,context.getString(R.string.api_Key));

        try{
            call.enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context,"Error !",Toast.LENGTH_SHORT ).show();
                    }
                    if (response.body() != null) {
                        listener.onFetchData(response.body().getArticles(), response.message());
                    } else {
                        listener.onError("Null response body");
                    }                }

                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                    listener.onError("Request Failed!!");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ManegerRequest(Context context) {
        this.context = context;
    }
    public  interface CallNewsApi{
        @GET("top-headlines")
        Call<NewsApiResponse> callhealines (
                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String apiKey
        );
    }

}
