package com.example.androidass2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidass2.javaClass.NewsHedlines;
import com.squareup.picasso.Picasso;

public class DetalisActivity extends AppCompatActivity {
    NewsHedlines hedlines;
    TextView txt_title , txtauthor, txttime,textdetail ,txtcontent;
    ImageView imgNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);

        txttime = findViewById(R.id.time);
        txt_title = findViewById(R.id.texttitle);
        txtauthor = findViewById(R.id.author);
        txtcontent= findViewById(R.id.textContent);
        textdetail= findViewById(R.id.textdetail);
        imgNews = findViewById(R.id.img_detalis);

        hedlines = (NewsHedlines) getIntent().getSerializableExtra("data");

        txt_title.setText(hedlines.getTitle());
        textdetail.setText(hedlines.getDescription());
        txtcontent.setText(hedlines.getContent());
        txttime.setText(hedlines.getPublishedAt());
        txtauthor.setText(hedlines.getAuthor());
        Picasso.get().load(hedlines.getUrlToImage()).into(imgNews);

    }
}