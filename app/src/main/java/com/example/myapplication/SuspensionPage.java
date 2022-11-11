package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuspensionPage extends AppCompatActivity {

    Button dismiss;
    Button tempSuspension;
    Button permSuspension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspension_page);

        dismiss=(Button)findViewById(R.id.button);
        tempSuspension=(Button)findViewById(R.id.button8);
        permSuspension=(Button)findViewById(R.id.button9);


        //Register
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SuspensionPage.this, ComplaintList.class);
                startActivity(intent);

            }
        });

        tempSuspension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SuspensionPage.this, ComplaintList.class);
                startActivity(intent);

            }
        });

        permSuspension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SuspensionPage.this, ComplaintList.class);
                startActivity(intent);

            }
        });
    }
}