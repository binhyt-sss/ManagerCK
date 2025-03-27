package com.cgm.circleK.dto;

import java.util.Date;

public class CheckHangHoaInPutDTO {
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    private int loaiHangId;
    private double phiVAT;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap; 
    private Integer thoiGianBaoHanh;
    private Double congSuatKW;
    private String nhaSanXuat;
    private Date ngayNhapKho; 
    // Constructor
    public CheckHangHoaInPutDTO(String tenHang, int soLuongTon, double donGia,
                                 int loaiHangId, double phiVAT, Date ngaySanXuat,
                                 Date ngayHetHan, String nhaCungCap,
                                 Integer thoiGianBaoHanh, Double congSuatKW,
                                 String nhaSanXuat, Date ngayNhapKho) {
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
        this.phiVAT = phiVAT;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuatKW = congSuatKW;
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getLoaiHangId() {
        return loaiHangId;
    }

    public void setLoaiHangId(int loaiHangId) {
        this.loaiHangId = loaiHangId;
    }

    public double getPhiVAT() {
        return phiVAT;
    }

    public void setPhiVAT(double phiVAT) {
        this.phiVAT = phiVAT;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public Integer getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(Integer thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public Double getCongSuatKW() {
        return congSuatKW;
    }

    public void setCongSuatKW(Double congSuatKW) {
        this.congSuatKW = congSuatKW;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
}
