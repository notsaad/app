package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cook_reg extends AppCompatActivity {

    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_reg);

        button6=(Button)findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(cook_reg.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}