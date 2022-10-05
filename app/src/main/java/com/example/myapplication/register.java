package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register extends AppCompatActivity {

    Button button3;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button3=(Button)findViewById(R.id.button3);
        button5=(Button)findViewById(R.id.button5);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(register.this, cook_reg.class);
                startActivity(intent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(register.this, ClientReg.class);
                startActivity(intent);

            }
        });

    }
}