package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClientReg extends AppCompatActivity {

    Button button4;
    //username is email
    EditText username, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_reg);

        button4=(Button)findViewById(R.id.button4);
        username = (EditText)findViewById(R.id.editTextTextPersonName5);
        password = (EditText)findViewById(R.id.editTextTextPersonName6);
        DB = new DBHelper(this);

        //Register
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(ClientReg.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();

                } else{
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser==false){
                        Boolean insert = DB.insertData(user,pass);
                        if(insert==true){
                            Toast.makeText(ClientReg.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ClientReg.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(ClientReg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }



            }
        });

    }
}