package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.todolist.Activities.XemChiTietActivity;
import com.example.todolist.Adapters.CongViecAdapter;
import com.example.todolist.Models.CongViec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCongViec;
    ArrayList<CongViec> listCV;
    CongViecAdapter adapterCongViec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec = findViewById(R.id.lvCongViec);
        listCV = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String thoiHan = "16/07/2024 12:27:05";
        try {
            listCV.add(new CongViec(1, "cv001", "Công việc 1", "Làm bài tập android", dateFormat.parse(thoiHan)));
        } catch (ParseException e) {
            Log.d("Lỗi thêm dữ liệu", e.toString());
        }

        adapterCongViec = new CongViecAdapter(MainActivity.this, R.layout.lv_congviec, listCV);
        lvCongViec.setAdapter(adapterCongViec);

        lvCongViec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent xemChiTietIntent = new Intent(getBaseContext(), XemChiTietActivity.class);
                Bundle data = new Bundle();
                CongViec cv = listCV.get(position);
                data.putSerializable("cv_value", cv);
                xemChiTietIntent.putExtras(data);
                startActivity(xemChiTietIntent);
                Toast.makeText(MainActivity.this, listCV.get(position).getTenCV(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}