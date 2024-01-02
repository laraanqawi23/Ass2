package com.example.androidass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
 private TextView Email,Pass;
 private CheckBox RemamberMe;
 private Button LogIN;
 private static final String SPref = "MyPrefs";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String REMEMBER = "remember";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email =findViewById(R.id.email);
        Pass= findViewById(R.id.loginpass);
        RemamberMe = findViewById(R.id.checkBox);
        LogIN = findViewById(R.id.But_sing);

        SharedPreferences sharedPreferences = getSharedPreferences(SPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (sharedPreferences.getBoolean(REMEMBER, false)) {
            Email.setText(sharedPreferences.getString(USERNAME, ""));
            Pass.setText(sharedPreferences.getString(PASSWORD, ""));
            RemamberMe.setChecked(true);
        }
        LogIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 login();
                Intent intent = new Intent(login.this, afterLogin.class);
                startActivity(intent);
            }
        });


    }

    private void login() {
        String username = Email.getText().toString();
        String password = Pass.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(SPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (RemamberMe.isChecked()) {

            editor.putString(USERNAME, username);
            editor.putString(PASSWORD, password);
            editor.putBoolean(REMEMBER, true);
            editor.apply();
        } else {
            editor.remove(USERNAME);
            editor.remove(PASSWORD);
            editor.remove(REMEMBER);
            editor.apply();
        }

        Toast.makeText(this, "Login Successful! ", Toast.LENGTH_SHORT).show();
    }



}