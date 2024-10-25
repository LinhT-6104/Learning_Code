package com.example.intentcoban;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DocBaoActivity extends AppCompatActivity {

    Button btnQuayLai;
    WebView wvDocBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_bao);

        btnQuayLai = findViewById(R.id.btnQuayLai);
        wvDocBao = findViewById(R.id.wvDocBao);

        String url = "https://dantri.com.vn/";
        wvDocBao.loadUrl(url);
        wvDocBao.getSettings().setJavaScriptEnabled(true);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}