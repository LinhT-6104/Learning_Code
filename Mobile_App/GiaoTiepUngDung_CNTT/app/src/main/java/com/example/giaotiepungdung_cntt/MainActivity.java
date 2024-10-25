package com.example.giaotiepungdung_cntt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnKichBan1, btnKichBan2, btnKichBan3;
    EditText edtSoN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        edtSoN = findViewById(R.id.edtSoN);
        btnKichBan1 = findViewById(R.id.btnKichBan1);
        btnKichBan2 = findViewById(R.id.btnKichBan2);
        btnKichBan3 = findViewById(R.id.btnKichBan3);
        //

        btnKichBan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentKichBan1 = new Intent(MainActivity.this, KichBan1Activity.class);
                startActivity(intentKichBan1);
            }
        });
        btnKichBan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String giaTriN = edtSoN.getText().toString().trim();
                int n = 0;
                if (giaTriN.length() > 0) {
                    n = Integer.parseInt(giaTriN);
                    Intent intentKichBan2 = new Intent(MainActivity.this, KichBan1Activity.class);
                    intentKichBan2.putExtra("n", n);
                    startActivity(intentKichBan2);
                    Toast.makeText(MainActivity.this, "Vui lòng nhập vào số N!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}