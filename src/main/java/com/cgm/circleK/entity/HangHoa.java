package com.cgm.circleK.entity;

public abstract class HangHoa {
    protected int maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;
    protected int loaiHangId;

    public HangHoa(String tenHang, int soLuongTon, double donGia, int loaiHangId) {
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
    }
    public HangHoa(int maHang ,String tenHang, double soLuongTon, double donGia, int loaiHangId) {
        this.maHang = maHang;
        this.tenHang = tenHang;  
        this.soLuongTon = (int) soLuongTon;
        this.donGia = donGia; 
        this.loaiHangId = loaiHangId;  
    }

    public int getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getLoaiHangId() {
        return loaiHangId;
    }

    public double getPhiVAT() {
        double phiVAT = tinhVat();
        return phiVAT;
    }

    public abstract double tinhVat();
}
