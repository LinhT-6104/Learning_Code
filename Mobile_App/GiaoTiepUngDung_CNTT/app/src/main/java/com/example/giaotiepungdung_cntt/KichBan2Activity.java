package com.example.giaotiepungdung_cntt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KichBan2Activity extends AppCompatActivity {

    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kich_ban2);

        tvKetQua = findViewById(R.id.tvKetQua);

        Intent intent = getIntent();
        int n = intent.getExtras().getInt("n", 0);
        tvKetQua.setText("n = " + n);

    }
}