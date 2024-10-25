package com.example.listviewcustom;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listviewcustom.Adapters.SanPhamAdapter;
import com.example.listviewcustom.Models.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSanPham;
    ArrayList<SanPham> listSanPham;
    SanPhamAdapter adapterSanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSanPham = findViewById(R.id.lvSanPham);
        listSanPham = new ArrayList<>();
        listSanPham.add(new SanPham("SP001", "Coca cola", 12000, R.drawable.coca_cola));
        listSanPham.add(new SanPham("SP002", "Cà phê", 25000, R.drawable.ca_phe));
        listSanPham.add(new SanPham("SP003", "Dừa", 20000, R.drawable.dua));
        listSanPham.add(new SanPham("SP004", "Oishi bí đỏ", 10000, R.drawable.oishi_bi_do));
        adapterSanPham = new SanPhamAdapter(MainActivity.this, R.layout.lv_sanpham, listSanPham);
        lvSanPham.setAdapter(adapterSanPham);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        MenuItem searchBar = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) searchBar.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                adapterSanPham.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterSanPham.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}