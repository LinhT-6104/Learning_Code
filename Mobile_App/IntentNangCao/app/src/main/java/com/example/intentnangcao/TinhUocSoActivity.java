package com.example.intentnangcao;

import static java.lang.Math.sqrt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class TinhUocSoActivity extends AppCompatActivity {

    TextView tvUocSo;
    Button btnKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_uoc_so);

        tvUocSo = findViewById(R.id.tvUocSo);
        btnKQ = findViewById(R.id.btnKQ);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        int n = data.getInt("n_value");
        btnKQ.setText("TRẢ VỀ ƯỚC SỐ CỦA " + n);
        ArrayList<Integer> listUoc = new ArrayList<>();
        for (int i = 1; i < (int)(sqrt(n)) + 1; i++) {
            if ( n % i == 0) {
                listUoc.add(i);
                if (i*i != n) {
                    listUoc.add(n/i);
                }
            }
        }
        Collections.sort(listUoc);
        String kq = "Các ước của " + n + " là: " + listUoc.toString();
        tvUocSo.setText(kq);

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(TinhUocSoActivity.this, MainActivity.class);
                Bundle data = new Bundle();
                data.putIntegerArrayList("listUoc", listUoc);
                backIntent.putExtras(data);
                setResult(RESULT_OK, backIntent);
                finish();
            }
        });
    }
}