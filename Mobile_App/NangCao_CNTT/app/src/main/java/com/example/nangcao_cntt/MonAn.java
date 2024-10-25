package com.example.nangcao_cntt;

import java.io.Serializable;

public class MonAn implements Serializable {
    String id;
    String ten;
    double gia;
    String hinhAnh;
    public MonAn() {}

    public MonAn(String id, String ten, double gia, String hinhAnh) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
