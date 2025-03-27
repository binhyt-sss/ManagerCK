package com.cgm.circleK.dto;

import java.util.Date;

public class UpdateHangHoaInPutDTO {
    private int maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    private int loaiHangId;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;
    private int thoiGianBaoHanh;
    private double congSuatKW;
    private String nhaSanXuat;
    private Date ngayNhapKho;

    // Constructor for general update
    public UpdateHangHoaInPutDTO(int maHang, String tenHang, int soLuongTon, double donGia, int loaiHangId) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
    }

    // Constructor for updating HangThucPham
    public UpdateHangHoaInPutDTO(int maHang, String tenHang, int soLuongTon, double donGia, int loaiHangId, Date ngaySanXuat, Date ngayHetHan, String nhaCungCap) {
        this(maHang, tenHang, soLuongTon, donGia, loaiHangId);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    // Constructor for updating HangDienMay
    public UpdateHangHoaInPutDTO(int maHang, String tenHang, int soLuongTon, double donGia, int loaiHangId, int thoiGianBaoHanh, double congSuatKW) {
        this(maHang, tenHang, soLuongTon, donGia, loaiHangId);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuatKW = congSuatKW;
    }

    // Constructor for updating HangSanhSu
    public UpdateHangHoaInPutDTO(int maHang, String tenHang, int soLuongTon, double donGia, int loaiHangId, String nhaSanXuat, Date ngayNhapKho) {
        this(maHang, tenHang, soLuongTon, donGia, loaiHangId);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    // Getters and setters
    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
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

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public double getCongSuatKW() {
        return congSuatKW;
    }

    public void setCongSuatKW(double congSuatKW) {
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