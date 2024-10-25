package com.example.intentsenddata;

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

    EditText edtNhapA, edtNhapB;
    Button btnGuiDL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNhapA = findViewById(R.id.edtNhapA);
        edtNhapB = findViewById(R.id.edtNhapB);
        btnGuiDL = findViewById(R.id.btnGuiDL);
        btnGuiDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(edtNhapA.getText().toString().trim());
                    int b = Integer.parseInt(edtNhapB.getText().toString().trim());
                    Bundle data = new Bundle();
                    data.putInt("a_value", a);
                    data.putInt("b_value", b);
                    Intent intentKQ = new Intent(MainActivity.this, ResultActivity.class);
                    intentKQ.putExtras(data);
                    startActivity(intentKQ);
                } catch (Exception e)  {
                    Toast.makeText(MainActivity.this, "Giá trị A và B không hợp lệ!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}