package com.example.todolist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.todolist.Models.CongViec;
import com.example.todolist.R;

import java.text.SimpleDateFormat;

public class XemChiTietActivity extends AppCompatActivity {

    TextView tvMaCV, tvTenCV, tvNoiDungCV, tvThoiHanCV;
    Button btnQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_chi_tiet);

        tvMaCV = findViewById(R.id.tvMaCV);
        tvTenCV = findViewById(R.id.tvTenCV);
        tvNoiDungCV = findViewById(R.id.tvNoiDungCV);
        tvThoiHanCV = findViewById(R.id.tvThoiHanCV);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        CongViec cv = (CongViec) data.get("cv_value");

        tvMaCV.setText(cv.getMaCV());
        tvTenCV.setText(cv.getTenCV());
        tvNoiDungCV.setText(cv.getNdCV());
        tvThoiHanCV.setText(dateFormat.format(cv.getThoiHan()));

        btnQuayLai = findViewById(R.id.btnQuayLai);
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}