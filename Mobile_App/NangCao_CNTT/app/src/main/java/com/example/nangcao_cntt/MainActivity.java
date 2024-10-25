package com.example.nangcao_cntt;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonAn;
    MonAnAdapter adapterMonAn;
    ArrayList<MonAn> listMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        lvMonAn = findViewById(R.id.lvMonAn);
        //

        listMonAn = new ArrayList<>();
        String duongDanAnh = "android.resource://" + R.class.getPackage().getName() + "/";
        listMonAn.add(new MonAn("MA001", "Gà rán", 62000, duongDanAnh + R.drawable.ga_ran));
        listMonAn.add(new MonAn("MA002", "", 62000, duongDanAnh + R.drawable.ga_ran));
        listMonAn.add(new MonAn("MA003", "Gà rán", 62000, duongDanAnh + R.drawable.ga_ran));
        listMonAn.add(new MonAn("MA004", "Gà rán", 62000, duongDanAnh + R.drawable.ga_ran));
        listMonAn.add(new MonAn("MA005", "Gà rán", 62000, duongDanAnh + R.drawable.ga_ran));
    }
}