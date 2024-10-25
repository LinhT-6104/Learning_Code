package com.example.intentnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtSoN;
    Button btnGuiDL;
    TextView tvNhapN, tvKetQua;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNhapN = findViewById(R.id.tvNhapN);
        edtSoN = findViewById(R.id.edtSoN);
        btnGuiDL = findViewById(R.id.btnGuiDL);
        tvKetQua = findViewById(R.id.tvKetQua);

        ActivityResultLauncher activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent intent = result.getData();
                            Bundle data = intent.getExtras();
                            ArrayList<Integer> listUocSo = data.getIntegerArrayList("listUoc");
                            String kq = "Các ước của " + n + " là: " + listUocSo.toString();
                            tvKetQua.setText(kq);
                        }
                    }
                }
        );

        btnGuiDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    n = Integer.parseInt(edtSoN.getText().toString());
                    Bundle data = new Bundle();
                    data.putInt("n_value", n);
                    Intent tinhUocSoIntent = new Intent(MainActivity.this, TinhUocSoActivity.class);
                    tinhUocSoIntent.putExtras(data);
                    activityResultLauncher.launch(tinhUocSoIntent);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Giá trị của n không hợp lệ!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}