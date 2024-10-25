package com.example.listviewcustom.Adapters;

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

import com.example.listviewcustom.Models.SanPham;
import com.example.listviewcustom.R;

import java.util.ArrayList;

public class SanPhamAdapter extends ArrayAdapter implements Filterable {
    Activity context;
    int resource;
    ArrayList<SanPham> listSanPham, listSanPhamBackup, listSanPhamFilter;
    public SanPhamAdapter(Activity context, int resource, ArrayList<SanPham> listSP) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.listSanPham = this.listSanPhamBackup = listSP;
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

        ImageView imgLogo = customView.findViewById(R.id.imgLogo);
        TextView tvID = customView.findViewById(R.id.tvID);
        TextView tvName = customView.findViewById(R.id.tvName);
        TextView tvPrice = customView.findViewById(R.id.tvPrice);
        Button btnView = customView.findViewById(R.id.btnView);

        SanPham sp = this.listSanPham.get(position);

        imgLogo.setImageResource(sp.getLogoSP());
        tvID.setText(sp.getMaSP());
        tvName.setText(sp.getTenSP());
        tvPrice.setText("Đơn giá: " + sp.getGiaSp() + " VNĐ");

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ketQua = "Mã sản phẩm: " + sp.getMaSP() + "\n"
                            + "Tên sản phẩm: " + sp.getTenSP() + "\n"
                            + "Đơn giá: " + sp.getGiaSp();
                Toast.makeText(context, ketQua, Toast.LENGTH_SHORT).show();
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
                String query = constraint.toString().toLowerCase().trim();
                if (query.length() < 1) {
                    listSanPhamFilter = listSanPhamBackup;
                } else {
                    listSanPhamFilter = new ArrayList<>();
                    for (SanPham sp : listSanPham) {
                        if (sp.getMaSP().toLowerCase().contains(query)
                        || sp.getTenSP().toLowerCase().contains(query)) {
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
