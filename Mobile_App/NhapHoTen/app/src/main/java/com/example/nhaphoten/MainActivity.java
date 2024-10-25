package com.example.nhaphoten;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText edtHoTen;
    Button btnGuiDL;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHoTen = findViewById(R.id.edtHoTen);
        btnGuiDL = findViewById(R.id.btnGuiDL);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnGuiDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtHoTen.getText().toString().trim();
                String ketQua = "";
                if (hoTen.length() > 0) {
                    ketQua = "Bạn chưa nhập đầy đủ họ tên!";
                    tvKetQua.setTextColor(Color.RED);
                } else {
                    ketQua = "Xin chào " + hoTen;
                    tvKetQua.setTextColor(Color.BLUE);
                }
                Toast.makeText(MainActivity.this, ketQua, Toast.LENGTH_SHORT).show();
                tvKetQua.setText(ketQua);
                tvKetQua.setTextSize(26);
            }
        });
    }
}