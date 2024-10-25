package com.example.listview_remake.Models;

import java.io.Serializable;

public class SanPham implements Serializable {
    String maSP;
    String tenSP;
    double giaSP;
    int logoSP;

    public SanPham() {}
    public SanPham(String maSP, String tenSP, double giaSP, int logoSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.logoSP = logoSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    public int getLogoSP() {
        return logoSP;
    }

    public void setLogoSP(int logoSP) {
        this.logoSP = logoSP;
    }
}
