package com.example.phieukhambenh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imgAvatar;
    RadioGroup radGroupGT;
    RadioButton radNam, radNu;
    EditText edtHoTen, edtNgaySinh, edtSDT;
    CheckBox cbxKSK, cbxXNM, cbxCXQ;
    TextView tvThanhTien, tvKetQua;
    Button btnXacNhan;
    int thanhTien = 0;

//    ArrayList<SinhVien> ádfádf = new

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAvatar = findViewById(R.id.imgAvatar);
        radGroupGT = findViewById(R.id.radGroupGT);
        radNam = findViewById(R.id.radNam);
        radNu = findViewById(R.id.radNu);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtSDT = findViewById(R.id.edtSDT);
        cbxKSK = findViewById(R.id.cbxKSK);
        cbxXNM = findViewById(R.id.cbxXNM);
        cbxCXQ = findViewById(R.id.cbxCXQ);
        tvThanhTien = findViewById(R.id.tvThanhTien);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnXacNhan = findViewById(R.id.btnXacNhan);

        radGroupGT.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radNam) {
                    imgAvatar.setImageResource(R.drawable.man);
                    Toast.makeText(MainActivity.this, "Giới tính nam", Toast.LENGTH_SHORT).show();
                } else {
                    imgAvatar.setImageResource(R.drawable.woman);
                    Toast.makeText(MainActivity.this, "Giới tính nữ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radNam.isChecked() || radNu.isChecked()) {
                    if (!edtHoTen.getText().toString().trim().isEmpty() &&
                        !edtNgaySinh.getText().toString().trim().isEmpty() &&
                        !edtSDT.getText().toString().trim().isEmpty()) {
                        if (cbxKSK.isChecked() || cbxXNM.isChecked() || cbxCXQ.isChecked()) {
                            String kq = "", gt = "", hoTen = "", ngaySinh = "", sdt = "", dv = "Dịch vụ:";
                            if (radNam.isChecked()) {
                                gt = "Nam";
                            } else {
                                gt = "Nữ";
                            }
                            hoTen = edtHoTen.getText().toString().trim();
                            ngaySinh = edtNgaySinh.getText().toString().trim();
                            sdt = edtSDT.getText().toString().trim();
                            if (cbxKSK.isChecked()) {
                                dv += "\n\t" + cbxKSK.getText().toString().trim();
                            }
                            if (cbxXNM.isChecked()) {
                                dv += "\n\t" + cbxXNM.getText().toString().trim();
                            }
                            if (cbxCXQ.isChecked()) {
                                dv += "\n\t" + cbxCXQ.getText().toString().trim();
                            }
                            kq += "Giới tính: " + gt + "\n" +
                                "Họ tên: " + hoTen + "\n" +
                                "Ngày sinh: " + ngaySinh + "\n" +
                                "Số điện thoại: " + sdt + "\n" +
                                dv + "\nThành tiền: " + thanhTien;
                            tvKetQua.setText(kq);
                        } else {
                            Toast.makeText(MainActivity.this, "Vui lòng chọn dịch vụ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Vui lòng điền họ tên, ngày sinh và sdt",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbxKSK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    thanhTien += 200000;
                } else {
                    thanhTien -= 200000;
                }
                tvThanhTien.setText(thanhTien + "");
            }
        });
        cbxXNM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    thanhTien += 350000;
                } else {
                    thanhTien -= 350000;
                }
                tvThanhTien.setText(thanhTien + "");
            }
        });
        cbxCXQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    thanhTien += 1000000;
                } else {
                    thanhTien -= 1000000;
                }
                tvThanhTien.setText(thanhTien + "");
            }
        });
    }
}