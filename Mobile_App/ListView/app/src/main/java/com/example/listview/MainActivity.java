package com.example.listview;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThoat, btnThemCV;
    EditText edtCongViec, edtTimKiemCV;
    ListView lvCongViec;
    ArrayList<String> listCongViec;
    ArrayAdapter adapterCV;
    String congViec = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ giao diện
        btnThoat = findViewById(R.id.btnThoat);
        btnThemCV = findViewById(R.id.btnThemCV);
        edtCongViec = findViewById(R.id.edtCongViec);
        edtTimKiemCV = findViewById(R.id.edtTimKiemCV);
        lvCongViec = findViewById(R.id.lvCongViec);
        // Khởi tạo dữ liệu
        listCongViec = new ArrayList<>();
        listCongViec.add("Học tiếng Anh");
        listCongViec.add("Tập gym");
        adapterCV = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listCongViec);
        lvCongViec.setAdapter(adapterCV);

        registerForContextMenu(lvCongViec);
        lvCongViec.setTextFilterEnabled(true);
        // Thiết lập sự kiện
        edtTimKiemCV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                adapterCV.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        btnThemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                congViec = edtCongViec.getText().toString().trim();
                if (congViec.length() > 0) {
                    if (!listCongViec.contains(congViec)){
                        listCongViec.add(congViec);
                        adapterCV.notifyDataSetChanged();
                        edtCongViec.setText("");
                        Toast.makeText(MainActivity.this, "Thêm công việc: " + congViec, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Công việc \"" + congViec + "\" đã tồn tại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng điền vào công việc mới!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogThoat = new AlertDialog.Builder(MainActivity.this);
                dialogThoat.setTitle("Thoát ứng dụng");
                dialogThoat.setMessage("Bạn thực sự muốn thoát?");
                dialogThoat.setIcon(R.drawable.power);
                dialogThoat.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialogThoat.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialogThoat.create().show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.listview_menu, menu);
        menu.setHeaderTitle("Thao tác với công việc");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo lvItemInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int viTri = lvItemInfo.position;
        String cvc = listCongViec.get((viTri));
        if (item.getItemId() == R.id.lvMenuSuaCV) {
            String cv= edtCongViec.getText().toString().trim();
            if (cv.length() > 0) {
                listCongViec.set(viTri, cv);
                adapterCV.notifyDataSetChanged();
                Toast.makeText(this, "Sửa CV: " + cv, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Vui lòng điền nội dung mới cho công việc " + cvc, Toast.LENGTH_SHORT).show();
            }
        }
        if (item.getItemId() == R.id.lvMenuXoaCV) {
            AlertDialog.Builder dialogXoaCV = new AlertDialog.Builder(MainActivity.this);
            dialogXoaCV.setTitle("Hệ thống");
            dialogXoaCV.setMessage("Bạn thực sự muốn xóa cv " + cvc + "?");
            dialogXoaCV.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    listCongViec.remove(viTri);
                    adapterCV.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Đã xóa công việc " + cvc, Toast.LENGTH_SHORT).show();
                }
            });
            dialogXoaCV.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            dialogXoaCV.create().show();
        }
        return super.onContextItemSelected(item);
    }
}
