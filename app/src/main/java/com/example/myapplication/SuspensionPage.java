package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class SuspensionPage extends AppCompatActivity {

    Button dismiss;
    Button tempSuspension;
    Button permSuspension;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspension_page);

        dismiss= findViewById(R.id.button);
        tempSuspension=findViewById(R.id.button8);
        permSuspension=findViewById(R.id.button9);


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
