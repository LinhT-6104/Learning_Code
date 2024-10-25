package com.example.thongtinsanphan.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thongtinsanphan.Models.SanPham;
import com.example.thongtinsanphan.R;

import java.util.ArrayList;

public class SanPhamAdapter extends ArrayAdapter implements Filterable {
    Activity context;
    int resource;
    ArrayList<SanPham> listSanPham, listSanPhamBackup, listSanPhamFilter;
    public SanPhamAdapter(Activity context, int resource, ArrayList<SanPham> listSanPham) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.listSanPham = listSanPhamBackup = listSanPham;
    }

    @Override
    public int getCount() {
        return listSanPham.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource, null);

        ImageView imgLogoSP = customView.findViewById(R.id.imgLogoSP);
        TextView tvMaSP = customView.findViewById(R.id.tvMaSP);
        TextView tvTenSP = customView.findViewById(R.id.tvTenSP);
        TextView tvGiaSP = customView.findViewById(R.id.tvGiaSP);
        Button btnView = customView.findViewById(R.id.btnView);

        SanPham sp = this.listSanPham.get(position);

        imgLogoSP.setImageResource(sp.getLogoSP());
        tvMaSP.setText(sp.getMaSP());
        tvTenSP.setText(sp.getTenSP());
        tvGiaSP.setText("Đơn giá: " + sp.getGiaSP() + " VNĐ");

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq = "Mã sản phẩm: " + sp.getMaSP() + "\n"
                        + "Tên sản phẩm: " + sp.getTenSP() + "\n"
                        + "Đơn giá: " + sp.getGiaSP() + " VNĐ";
                Toast.makeText(context, kq, Toast.LENGTH_SHORT).show();
            }
        });
        return customView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query = constraint.toString();
                if (query.length() < 1) {
                    listSanPhamFilter = listSanPhamBackup;
                } else {
                    listSanPhamFilter = new ArrayList<>();
                    for (SanPham sp : listSanPhamBackup) {
                        if (sp.getMaSP().toLowerCase().contains(query) || sp.getTenSP().contains(query)) {
                            listSanPhamFilter.add(sp);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listSanPhamFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listSanPham = (ArrayList<SanPham>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
