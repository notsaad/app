package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ComplaintList extends AppCompatActivity {

    String[] chefList = new String[]{"Gordon Ramsay", "Leblanc Poulet", "Monsieur Brun Riz"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper DB = new DBHelper(this);


        setContentView(R.layout.activity_complaint_list);
        listView = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),chefList);
        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i("CUSTOM_LIST_VIEW","Item is clicked @ Position :: " + position);

                Intent intent = new Intent(ComplaintList.this, SuspensionPage.class);
                startActivity(intent);
            }
        });
    }
}