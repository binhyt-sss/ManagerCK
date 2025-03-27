package com.cgm.circleK.entity;

import java.util.Date;

public class HangThucPham extends HangHoa {
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String tenHang, int soLuongTon, double donGia, int loaiHangId, Date ngaySanXuat, Date ngayHetHan, String nhaCungCap) {
        super(tenHang, soLuongTon, donGia, 1);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }
    public HangThucPham(int maHang,String tenHang, int soLuongTon, double donGia, int loaiHangId, Date ngaySanXuat, Date ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia, 1);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVat() {
        return donGia * 0.05;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }
}