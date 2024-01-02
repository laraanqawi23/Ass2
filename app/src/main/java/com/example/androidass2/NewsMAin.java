package com.example.androidass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.androidass2.javaClass.NewsApiResponse;
import com.example.androidass2.javaClass.NewsHedlines;

import java.util.List;

public class NewsMAin extends AppCompatActivity implements SelectListner {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    private Button Coin;
    private Button News;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);
        Handler handler = new Handler(Looper.getMainLooper());

        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            String extraText = intent.getStringExtra(Intent.EXTRA_TEXT);
            if (extraText.equals("News")) {

                dialog = new ProgressDialog(this);
                dialog.setTitle("Fetching News articles....");
                dialog.show();

                ManegerRequest r1 = new ManegerRequest(this);
                r1.getNewsHeadlines(listener,"general",null);
                handler.postDelayed(() -> {
                    Toast.makeText(this, "Click on any news to see details", Toast.LENGTH_SHORT).show();
                }, 2000);
            }else {
                dialog = new ProgressDialog(this);
                dialog.setTitle("Fetching Coin News articles....");
                dialog.show();

                ManegerRequestCoin r2 =new ManegerRequestCoin(this);
                r2.getNewsHeadlines(listener,"general",null);
                handler.postDelayed(() -> {
                    Toast.makeText(this, "Click on any news to see details", Toast.LENGTH_SHORT).show();
                }, 2000);
            }

        }


    }

    private final onfetchdatalistener<NewsApiResponse> listener = new onfetchdatalistener<NewsApiResponse>() {

        @Override
        public void onFetchData(List<NewsHedlines> list, String message) {
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHedlines> list) {
        recyclerView= findViewById(R.id.recycler_Main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onNEwsCliced(NewsHedlines hedlines) {
        startActivity(new Intent(NewsMAin.this,DetalisActivity.class)
                .putExtra("data",hedlines));
    }

    @Override
    public void onCionCliced(NewsHedlines hedlines) {
        startActivity(new Intent(NewsMAin.this,DetalisActivity.class)
                .putExtra("data",hedlines));
    }
}