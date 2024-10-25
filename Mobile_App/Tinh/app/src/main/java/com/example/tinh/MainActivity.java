package com.example.tinh;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvKetQua;
    EditText edtNhapA, edtNhapB;
    Button btnTinhToan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvKetQua = findViewById(R.id.tvKetQua);
        edtNhapA = findViewById(R.id.edtNhapA);
        edtNhapB = findViewById(R.id.edtNhapB);
        btnTinhToan = findViewById(R.id.btnTinhToan);
        btnTinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double soA = 0, soB = 0;
                String ketQua = "";
                try {
                    soA = Double.parseDouble(edtNhapA.getText().toString());
                    soB = Double.parseDouble(edtNhapB.getText().toString());
                    double tong = soA + soB;
                    double hieu = soA - soB;
                    double tich = soA * soB;
                    double thuong = soA / soB;
                    ketQua = soA + " + " + soB + " = " + tong + "\n";
                    ketQua += soA + " - " + soB + " = " + hieu + "\n";
                    ketQua += soA + " * " + soB + " = " + tich + "\n";
                    ketQua += soA + " / " + soB + " = " + thuong;
                    tvKetQua.setText(ketQua);
                    tvKetQua.setTextColor(Color.parseColor("#00FF00"));
                } catch (Exception e) {
                    e.printStackTrace();
                    soA = soB = 0;
                    tvKetQua.setText("Giá trị của A và B không hợp lệ! vui lòng nhập lại.");
                    tvKetQua.setTextColor(Color.parseColor("#f70c0c"));
                }
            }
        });
    }
}