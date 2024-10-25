package com.example.clickme;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThoat;
    ListView lvMonHoc;
    ArrayList<String> listMonHoc;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThoat = findViewById(R.id.btnThoat);

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Thoat");
                b.setMessage("Ban co thuc su muon thoat?");
                b.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                b.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                b.create().show();
            }
        });
        addViews();
        addevents();
    }

    private void addViews() {
        lvMonHoc = findViewById(R.id.lvMonHoc);
        listMonHoc = new ArrayList<>();
        listMonHoc.add("Toán");
        listMonHoc.add("Vậy lí");
        listMonHoc.add("Tiếng Anh");
        listMonHoc.add("Hóa");
        adapter = new ArrayAdapter(MainActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    listMonHoc);
        lvMonHoc.setAdapter(adapter);
    }
    private void addevents() {
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paren343t, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                                parent.getItemAtPosition(position).toString(),
                                Toast.LENGTH_SHORT).show();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                                "Long click: " + parent.getItemAtPosition(position).toString(),
                                Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}