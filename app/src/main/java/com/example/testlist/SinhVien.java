package com.example.testlist;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String ten;
    private String id;
    private String gioitinh;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public SinhVien(String ten, String id, String gioitinh) {
        this.ten = ten;
        this.id = id;
        this.gioitinh = gioitinh;
    }

    public SinhVien() {
    }

    @NonNull
    @Override
    public String toString() {
        String s = "Sinh vien: " + ten + " - " + id + " - " +gioitinh;
        return s;
    }
}
