package com.example.androidass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class afterLogin extends AppCompatActivity {
    private  Button Coin;
     private Button News;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        Coin = findViewById(R.id.butpl);
        News = findViewById(R.id.butUs);

        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(afterLogin.this, NewsMAin.class);
                intent.putExtra(intent.EXTRA_TEXT,"News");
                startActivity(intent);

            }
        });

        Coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(afterLogin.this, NewsMAin.class);
                intent.putExtra(intent.EXTRA_TEXT,"Coin");
                startActivity(intent);
            }
        });

    }
}