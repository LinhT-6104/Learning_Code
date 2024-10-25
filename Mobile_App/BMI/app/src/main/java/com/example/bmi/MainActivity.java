package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtChieuCao, edtCanNang;
    Button btnTinh;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtChieuCao = findViewById(R.id.edtChieuCao);
        edtCanNang = findViewById(R.id.edtCanNang);
        btnTinh = findViewById(R.id.btnTinh);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strChieuCao = edtChieuCao.getText().toString().trim();
                String strCanNang = edtCanNang.getText().toString().trim();

                if (!strChieuCao.equals("") && !strCanNang.equals("")) {
                    float canNang = Float.parseFloat(strCanNang);
                    float chieuCao = Float.parseFloat(strChieuCao);
                    float bmi = canNang / (chieuCao * chieuCao);
                    String danhGia = "";
                    if (bmi < 18.5) { danhGia = "Gầy"; }
                    else if (bmi <= 24.9) { danhGia = "Bình thường"; }
                    else if (bmi <= 29.9) { danhGia = "Thừa cân"; }
                    else if (bmi <= 34.9) { danhGia = "Béo phì I"; }
                    else { danhGia = "Béo phì II"; }
                    String ketQua = "BMI của bạn là " + String.format("%.2f", bmi) + "\n" + danhGia + "!";
                    Toast.makeText(MainActivity.this, ketQua , Toast.LENGTH_SHORT).show();
                    tvKetQua.setVisibility(View.VISIBLE);
                    tvKetQua.setText(ketQua);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    tvKetQua.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}