package com.example.androidass2;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidass2.javaClass.NewsApiResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

public class  newsrequest{
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static final String EVERYTHING_ENDPOINT = "everything";

    private Context context;

    public newsrequest(Context context) {
        this.context = context;
    }

    public void getNewsHeadlines(onfetchdatalistener listener, String category, String query) {
        String url = BASE_URL + EVERYTHING_ENDPOINT + "?title=" + "&description=" + category + "&q=" + query +
                "&apiKey=" + context.getString(R.string.api_Key);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        NewsApiResponse newsApiResponse = gson.fromJson(response.toString(), NewsApiResponse.class);
                        listener.onFetchData(newsApiResponse.getArticles(), "Success");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
                        listener.onError("Request Failed!!");
                    }
                });

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
