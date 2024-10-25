package com.example.nangcao_cntt;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MonAnAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<MonAn> listMonAn;

    public MonAnAdapter(@NonNull Context context, int resource, Context context1, int resource1, ArrayList<MonAn> listMonAn) {
        super(context, resource);
        this.context = context1;
        this.resource = resource1;
        this.listMonAn = listMonAn;
    }

    @Override
    public int getCount() {
        return this.listMonAn.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View customView = layoutInflater.inflate(resource, null);
        // Ánh xạ
        ImageView imgMonAn = customView.findViewById(R.id.imgMonAn);
        TextView tvTenMonAn = customView.findViewById(R.id.tvTenMonAn);
        TextView tdDonGia = customView.findViewById(R.id.tdDonGia);
        Button btnXemChiTiet = customView.findViewById(R.id.btnXemChiTiet);
        Button btnThemVaoGio = customView.findViewById(R.id.btnThemVaoGio);
        // Thiet lap gia tri
        MonAn monAn = listMonAn.get(position);
        tvTenMonAn.setText(monAn.getTen());
        tvDonGia.setText("Giá bán: " + monAn.getGia());
        // Hiển thị hình ảnh món ăn
        String hinhAnh monAn.getHinhAnh();
        Uri uri = Uri.parse(hinhAnh);
        imgMonAn.setImageURI(uri);
        return customView;
    }

}
