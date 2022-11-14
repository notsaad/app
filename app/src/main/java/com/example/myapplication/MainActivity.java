package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button button1;
    Button button2;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName2);
        DB = new DBHelper(this);
        SharedPreferences.Editor editor = getSharedPreferences("name", MODE_PRIVATE).edit();
        editor.putString("email", String.valueOf(username));
        editor.putString("password", String.valueOf(password));
        editor.putBoolean("isLoggedIn", true);
        editor.apply();

        //Register
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);

            }
        });

        //Login
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                String adminuser = "admin";
                String adminpass = "pass";
                Boolean insert = DB.insertData(adminuser, adminpass);


                if (user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (DB.checkusernamepassword("admin","pass")){ //Send to complaint page
                        Toast.makeText(MainActivity.this,"Admin sign in successful. To Complaints Page",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ComplaintList.class);
                        startActivity(intent);
                    }
                    else if (checkuserpass == true) {
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }




        }
    });
                button2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String pass = password.getText().toString();
                        String user = username.getText().toString();
                        Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                        if(checkuserpass == true) {
                            String typeofuser;
                            typeofuser = DB.checkUser(username.getText().toString()); //get user type from database
                            if(typeofuser.equals("Admin")) {
                                Intent mainintent = new Intent(MainActivity.this, login.class);
                                startActivity(mainintent);}
                            else if (typeofuser.equals("Client")){
                                Intent intent = new Intent(MainActivity.this, loginClient.class);
                                startActivity(intent);}
                            else if (typeofuser.equals("Cook")){
                                Intent intent = new Intent(MainActivity.this, loginCook.class);
                                startActivity(intent);}
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Wrong email or password", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
