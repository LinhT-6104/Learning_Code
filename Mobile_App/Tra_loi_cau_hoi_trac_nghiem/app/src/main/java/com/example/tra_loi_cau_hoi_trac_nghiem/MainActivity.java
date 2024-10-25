package com.example.tra_loi_cau_hoi_trac_nghiem;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup radgTP;
    RadioButton radBangkok, radHaNoi, radHCM, radLondon;
    TextView tvLuaChon;
    Button btnTraLoi, btnXemDapAn;
    ArrayList<RadioButton> lstButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radgTP = findViewById(R.id.radgTP);
        radBangkok = findViewById(R.id.radBangkok);
        radHaNoi = findViewById(R.id.radHaNoi);
        radHCM = findViewById(R.id.radHCM);
        radLondon = findViewById(R.id.radLondon);
        tvLuaChon = findViewById(R.id.tvLuaChon);
        btnTraLoi = findViewById(R.id.btnTraLoi);
        btnXemDapAn = findViewById(R.id.btnXemDapAn);
        lstButton = new ArrayList<>();
        lstButton.add(radBangkok);
        lstButton.add(radHaNoi);
        lstButton.add(radHCM);
        lstButton.add(radLondon);


        radgTP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId" )
            public void setColor(ArrayList<RadioButton> lstButton) {
                for (int i = 0; i < lstButton.size(); i++) {
                        lstButton.get(i).setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                setColor(lstButton);
                if (radBangkok.isChecked()) {
                    tvLuaChon.setText("Bạn chọn: " + radBangkok.getText().toString());
                }
                if (radHaNoi.isChecked()) {
                    tvLuaChon.setText("Bạn chọn: " + radHaNoi.getText().toString());
                }
                if (radHCM.isChecked()) {
                    tvLuaChon.setText("Bạn chọn: " + radHCM.getText().toString());
                }
                if (radLondon.isChecked()) {
                    tvLuaChon.setText("Bạn chọn: " + radLondon.getText().toString());
                }
            }
        });

        btnTraLoi.setOnClickListener(new View.OnClickListener() {

            public void setColor(int k, ArrayList<RadioButton> lstButton) {
                for (int i = 0; i < lstButton.size(); i++) {
                    if (i != k) {
                        lstButton.get(i).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                }
            }

            @Override
            public void onClick(View v) {
                if (radBangkok.isChecked()) {
                    try {
                        radBangkok.setBackgroundColor(Color.parseColor("#ED1C24"));
                        setColor(0, lstButton);
                    } catch (Exception e) {
                        tvLuaChon.setText("Lỗi màu radBangkok");
                    }
                }
                if (radHaNoi.isChecked()) {
                    try {
                        radHaNoi.setBackgroundColor(Color.parseColor("#62FD6F"));
                        setColor(1, lstButton);
                    } catch (Exception e) {
                        tvLuaChon.setText("Lỗi màu radHaNoi");
                    }
                }

                if (radHCM.isChecked()) {
                    try {
                        setColor(2, lstButton);
                        radHCM.setBackgroundColor(Color.parseColor("#ED1C24"));
                    } catch (Exception e) {
                        tvLuaChon.setText("Lỗi màu radHCM");
                    }
                }
                if (radLondon.isChecked()) {
                    try {
                        setColor(3, lstButton);
                        radLondon.setBackgroundColor(Color.parseColor("#ED1C24"));
                    } catch (Exception e) {
                        tvLuaChon.setText("Lỗi màu radLondon");
                    }
                }
            }
        });

        btnXemDapAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radHaNoi.setBackgroundColor(Color.parseColor("#62FD6F"));
                radBangkok.setBackgroundColor(Color.parseColor("#FFFFFF"));
                radHCM.setBackgroundColor(Color.parseColor("#FFFFFF"));
                radLondon.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
    }
}