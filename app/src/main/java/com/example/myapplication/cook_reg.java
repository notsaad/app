package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cook_reg extends AppCompatActivity {

    EditText username, password;
    Button button6;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_reg);

        button6=(Button)findViewById(R.id.button6);
        username = (EditText)findViewById(R.id.editTextTextPersonName19);
        password = (EditText)findViewById(R.id.editTextTextPersonName20);
        DB = new DBHelper(this);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();


                if(user.equals("")||pass.equals("")){
                    Toast.makeText(cook_reg.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();

                } else{
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser==false){
                        Boolean insert = DB.insertData(user,pass);
                        if(insert==true){
                            Toast.makeText(cook_reg.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(cook_reg.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(cook_reg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });

    }
}