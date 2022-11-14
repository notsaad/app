package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String[] complaintList;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String [] listComplaint){
        this.context = ctx;
        this.complaintList = listComplaint;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return complaintList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView = (TextView) convertView.findViewById(R.id.textView);
        txtView.setText(complaintList[position]);
        return convertView;
    }
}

