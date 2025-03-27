package com.cgm.circleK.dto;

import java.util.Date;

public class AddHangHoaInPutDTO {
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;
    protected int loaiHangId;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;
    private int thoiGianBaoHanh;
    private double congSuat;
    private String nhaSanXuat;
    private Date ngayNhapKho;

    // Constructors
    public AddHangHoaInPutDTO(String tenHang, int soLuongTon, double donGia, int loaiHangId) {
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
    }

    public AddHangHoaInPutDTO(String tenHang, int soLuongTon, double donGia, int loaiHangId, Date ngaySanXuat, Date ngayHetHan, String nhaCungCap) {
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    public AddHangHoaInPutDTO(String tenHang, int soLuongTon, double donGia, int loaiHangId, int thoiGianBaoHanh, double congSuat) {
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    public AddHangHoaInPutDTO(String tenHang, int soLuongTon, double donGia, int loaiHangId, String nhaSanXuat, Date ngayNhapKho) {
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    // Getters and Setters
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

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
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