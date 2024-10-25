package com.example.todolist_ver1;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCongViec;
    ArrayList<String> listCV;
    ArrayAdapter adapterCV;
    EditText edtCongViec, edtTimKiem;
    Button btnThoat, btnThemCV, btnLuuCV;
    TextView tvCongViecChon;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCongViec = findViewById(R.id.edtCongViec);
        btnThemCV = findViewById(R.id.btnThemCV);
        lvCongViec = findViewById(R.id.lvCongViec);
        btnThoat = findViewById(R.id.btnThoat);
        btnLuuCV = findViewById(R.id.btnLuuCV);
        tvCongViecChon = findViewById(R.id.tvCongViecChon);
        edtTimKiem = findViewById(R.id.edtTimKiem);

        listCV = new ArrayList<>();
        listCV.add("Rửa bát");
        listCV.add("Học lập trình di động");
        listCV.add("Ôn thi Tiếng Anh VSTEP");

        adapterCV = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, listCV);
        lvCongViec.setAdapter(adapterCV);

        lvCongViec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Bạn vừa chọn '" + listCV.get(position) + "'", Toast.LENGTH_SHORT).show();
                selectedIndex = position;
                String congViec = listCV.get(selectedIndex);
                tvCongViecChon.setText("Đang chọn: " + congViec + " - index = " + selectedIndex);
                edtCongViec.setText(congViec);
            }
        });

        lvCongViec.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String xoaCV = listCV.get(position);
                AlertDialog.Builder dialogXoa = new AlertDialog.Builder(MainActivity.this);
                dialogXoa.setTitle("Xóa phần tử");
                dialogXoa.setMessage("Bạn muốn xóa công việc: '" + xoaCV + "'?");
                dialogXoa.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listCV.remove(position); // Xóa dữ liệu trong ArrayList
                        adapterCV.notifyDataSetChanged(); // Thông báo sự thay đổi về dữ liệu
                        Toast.makeText(MainActivity.this, "Đã xóa '" + xoaCV + "'", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogXoa.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialogXoa.create().show();
                return false;
            }
        });

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapterCV.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        btnLuuCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String congViecMoi = edtCongViec.getText().toString().trim();
                if (congViecMoi.length() > 0 && selectedIndex > -1) {
                    String congViecCu = listCV.get(selectedIndex);
                    listCV.set(selectedIndex, congViecMoi);
                    adapterCV.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Đã sửa " + congViecCu + " ==> " + congViecMoi, Toast.LENGTH_SHORT).show();
                    selectedIndex = -1;
                    edtCongViec.setText("");
                    tvCongViecChon.setText("Chọn công việc để sửa...");
                } else {
                    Toast.makeText(MainActivity.this, "Chọn 1 công việc và nhập tên mới dể sửa!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String congViecMoi = edtCongViec.getText().toString().trim();
                if (congViecMoi.length() > 0) {
                    listCV.add(congViecMoi);
                    adapterCV.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập công việc mới!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogThoat = new AlertDialog.Builder(MainActivity.this);
                dialogThoat.setTitle("Thoát ứng dụng");
                dialogThoat.setMessage("Bạn thực sự muốn thoát?");
                dialogThoat.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { finish(); } });
                dialogThoat.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { dialog.cancel(); } });
                dialogThoat.create().show();
            }
        });
    }
}