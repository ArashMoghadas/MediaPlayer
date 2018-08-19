package com.example.asus.mediaplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends ArrayAdapter<String>{
    public myAdapter(@NonNull Context context, @NonNull List<String> name) {
        super(context, 0, name);
    }
    @SuppressLint("WrongConstant")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.music_item, parent, false);
        }
        String name = getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.name);
        nameTextView.setText(name);


        ImageView picImageView = convertView.findViewById(R.id.pic);
        picImageView.setVisibility(R.drawable.ts);
        return convertView;
    }
}
