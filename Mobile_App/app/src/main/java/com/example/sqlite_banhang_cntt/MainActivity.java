package com.example.sqlite_banhang_cntt;

import android.content.Intent;
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

import com.example.sqlite_banhang_cntt.Database.MySQLite;
import com.example.sqlite_banhang_cntt.Model.TaiKhoan;

public class MainActivity extends AppCompatActivity {
    EditText edtTenDangNhap, edtMatKhau;
    Button btnDangNhap;
    TextView tvTrangThai;
    MySQLite mySQLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        tvTrangThai = findViewById(R.id.tvTrangThai);
        mySQLite = new MySQLite(MainActivity.this, MySQLite.DATABASE_NAME, null, 1);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenDangNhap = edtTenDangNhap.getText().toString().trim();
                String matKhau = edtMatKhau.getText().toString().trim();
                if (tenDangNhap.length() > 0 && matKhau.length() > 0) {
                    TaiKhoan taiKhoan = mySQLite.kiemTraDangNhap(tenDangNhap, matKhau);
                    if (taiKhoan.getId() > 0 && taiKhoan.getVaiTro() > 0) {
                        if (taiKhoan.getVaiTro() == 1) {
                            Intent intentQuanTri= new Intent(MainActivity.this, TrangQuanTriActivity.class);
                            intentQuanTri.putExtra("taiKhoan", taiKhoan);
                            startActivity(intentQuanTri);
                        }
                        if (taiKhoan.getVaiTro() == 2) {
                            Intent intentDatHang= new Intent(MainActivity.this, TrangQuanTriActivity.class);
                            intentDatHang.putExtra("taiKhoan", taiKhoan);
                            startActivity(intentDatHang);
                        }
                    } else Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(MainActivity.this, "Vui lòng nhập tài khoản và mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}