package com.example.chuongtrinhgoidienthoai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView edtPhoneNumber, tvThongBao;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnC, btnX, btnGoi;
    String ketQua = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        tvThongBao = findViewById(R.id.tvThongBao);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnC = findViewById(R.id.btnC);
        btn0 = findViewById(R.id.btn0);
        btnX = findViewById(R.id.btnX);
        btnGoi = findViewById(R.id.btnGoi);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "1";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "2";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "3";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "4";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "5";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "6";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "7";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "8";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "9";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua += "0";
                edtPhoneNumber.setText(ketQua);
                tvThongBao.setText(" ");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketQua = "";
                edtPhoneNumber.setText("Phone number...");
                tvThongBao.setText("Vui vòng nhập số điện thoại!");
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ketQua.length() > 1) {
                    ketQua = ketQua.substring(0, ketQua.length() - 1);
                    edtPhoneNumber.setText(ketQua);
                } else {
                    ketQua = "";
                    edtPhoneNumber.setText("Phone number...");
                    tvThongBao.setText("Vui vòng nhập số điện thoại!");
                }
            }
        });
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ketQua.length() >= 1) {
                    edtPhoneNumber.setText("Calling " + ketQua + "...");
                }
            }
        });
    }
}