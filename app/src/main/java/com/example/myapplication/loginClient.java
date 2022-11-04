package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class loginClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button signOut = (Button) findViewById(R.id.signOut);
        SharedPreferences.Editor editor = getSharedPreferences("name", MODE_PRIVATE).edit();
        editor.putString("password", "");
        editor.putString("email", "");
        editor.putBoolean("isLoggedIn", false);
        editor.apply();

        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("name", MODE_PRIVATE);
        boolean isLoggedIn= prefs.getBoolean("isLoggedIn", false);

        if(isLoggedIn){
            startActivity(new Intent(getApplicationContext(),login.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_login);


        signOut.setOnClickListener(view -> {

            Intent intent = new Intent(loginClient.this, MainActivity.class);
            startActivity(intent);

        });
    }}