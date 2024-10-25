package com.example.quanlymonhoc;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMonHoc;
    Button btnThem, btnSua, btnXoa;
    ListView lvMonHoc;
    ArrayAdapter adapter;
    ArrayList<String> listMonHoc;
    int selectedIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvents();
    }

    private void addEvents() {
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (selectedIndex >= 0) {
                    adapterView.getChildAt(selectedIndex).setBackgroundColor(Color.WHITE);
                }
                adapterView.getChildAt(i).setBackgroundColor(Color.parseColor("#AAF4ED"));
                selectedIndex = i;
                edtMonHoc.setText(adapterView.getItemAtPosition(selectedIndex).toString());
                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(selectedIndex).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = edtMonHoc.getText().toString().trim();
                if (!monHoc.equals("")) {
                    if (listMonHoc.contains(monHoc)) {
                        Toast.makeText(MainActivity.this, "Môn " + monHoc + " đã tồn tại", Toast.LENGTH_SHORT).show();
                    } else {
                        listMonHoc.add(monHoc);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng điền tên môn học", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = edtMonHoc.getText().toString().trim();
                if (!monHoc.equals("") && selectedIndex >= 0) {
                    listMonHoc.set(selectedIndex, monHoc);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn môn học", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex >= 0) {
                    AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                    b.setTitle("Xóa môn học");
                    b.setMessage("Xóa nhận xóa môn " + adapter.getItem(selectedIndex).toString() + " ?");
                    b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            lvMonHoc.getChildAt(selectedIndex).setBackgroundColor(Color.WHITE);
                            listMonHoc.remove(selectedIndex);
                            adapter.notifyDataSetChanged();
                            selectedIndex = -1;
                            edtMonHoc.setText("");
                        }
                    });
                    b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    b.create().show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn môn học", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addView() {
        edtMonHoc=findViewById(R.id.edtMonHoc);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
        lvMonHoc=findViewById(R.id.lvMonHoc);
        listMonHoc=new ArrayList<>();
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, listMonHoc);
        lvMonHoc.setAdapter(adapter);
    }
}