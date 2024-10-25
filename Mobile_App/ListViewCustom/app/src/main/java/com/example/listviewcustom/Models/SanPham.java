package com.example.listviewcustom.Models;

import java.io.Serializable;

public class SanPham implements Serializable {
    String maSP;
    String tenSP;
    double giaSp;
    int logoSP;
    public SanPham() {}
    public SanPham(String maSP, String tenSP, double giaSp, int logoSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSp = giaSp;
        this.logoSP = logoSP;
    }

    public String getMaSP() { return maSP; }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(double giaSp) {
        this.giaSp = giaSp;
    }

    public int getLogoSP() {
        return logoSP;
    }

    public void setLogoSP(int logoSP) {
        this.logoSP = logoSP;
    }
}
