package com.example.todolist.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todolist.Models.CongViec;
import com.example.todolist.R;

import java.util.ArrayList;

public class CongViecAdapter extends ArrayAdapter {
    Activity context;
    int resource;
    ArrayList<CongViec> listCV;
    public CongViecAdapter (Activity context, int resource, ArrayList<CongViec> listCV) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.listCV = listCV;
    }

    @Override
    public int getCount() {
        return this.listCV.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View customView = inflater.inflate(resource, null);

        TextView tvTitle = customView.findViewById(R.id.tvTitle);
        ImageView imgEdit = customView.findViewById(R.id.imgEdit);
        ImageView imgDelete = customView.findViewById(R.id.imgDelete);

        CongViec cv = listCV.get(position);

        tvTitle.setText(cv.getMaCV() + "-" + cv.getTenCV());
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Edit " + cv.getMaCV() + "-" + cv.getTenCV(), Toast.LENGTH_SHORT).show();
            }
        });

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Delete " + cv.getMaCV() + "-" + cv.getTenCV(), Toast.LENGTH_SHORT).show();
            }
        });

        return customView;
    }
}
