    package com.example.intentsenddata;

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

public class ResultActivity extends AppCompatActivity {

    Button btnQuayLai;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnQuayLai = findViewById(R.id.btnQuayLai);
        tvKetQua = findViewById(R.id.tvKetQua);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        int a = data.getInt("a_value");
        int b = data.getInt("b_value");
        String kq = a + " + " + b + " = " + (a + b) + "\n"
                + a + " - " + b + " = " + (a - b) + "\n"
                + a + " * " + b + " = " + (a * b) + "\n"
                + a + " / " + b + " = " + (a / b*1.0);
        tvKetQua.setText(kq);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}