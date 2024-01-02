package com.example.androidass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private EditText NAme;
    private TextView Pass  , CPass;
    private Button SignUp;

    private static final String SPref1 = "MyPrefs";
    private static final String USERNAME1 = "username";
    private static final String PASSWORD1 = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        NAme =findViewById(R.id.name);
        Pass = findViewById(R.id.signupnpass);
        CPass = findViewById(R.id.canfPass);
        SignUp = findViewById(R.id.But_sing);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp ();
            }
        });
    }

    private void signUp() {
        String username = NAme.getText().toString();
        String password = Pass.getText().toString();
        String Cpassword = CPass.getText().toString();

        if (password.equals(Cpassword)){
            saveUserDetails(username, password,Cpassword);
            Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Registration.this, afterLogin.class);
            startActivity(intent);
        }else
            Toast.makeText(this, "Mismatched passwords!!", Toast.LENGTH_SHORT).show();
    }


    private void saveUserDetails(String username, String password,String CPassword) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();

        String username = NAme.getText().toString();
        String password = Pass.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences(SPref1, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME1, username);
        editor.putString(PASSWORD1, password);
        editor.apply();
    }
    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences(SPref1, Context.MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString(USERNAME1, "");
        String savedPassword = sharedPreferences.getString(PASSWORD1, "");

        NAme.setText(savedUsername);
        Pass.setText(savedPassword);
        CPass.setText(savedPassword);
    }

}