package com.example.todolist.Models;

import java.io.Serializable;
import java.util.Date;

public class CongViec implements Serializable {
    int key;
    String maCV;
    String tenCV;
    String ndCV;
    Date thoiHan;
    public CongViec() {}

    public CongViec(int key, String maCV, String tenCV, String ndCV, Date thoiHan) {
        this.key = key;
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.ndCV = ndCV;
        this.thoiHan = thoiHan;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getNdCV() {
        return ndCV;
    }

    public void setNdCV(String ndCV) {
        this.ndCV = ndCV;
    }

    public Date getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Date thoiHan) {
        this.thoiHan = thoiHan;
    }
}
