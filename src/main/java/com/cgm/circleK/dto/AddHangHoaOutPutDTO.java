package com.cgm.circleK.dto;

import java.util.Date;

public class AddHangHoaOutPutDTO {
    private int maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    private int loaiHangId;
    private double phiVAT;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;
    private int thoiGianBaoHanh;
    private double congSuat;
    private String nhaSanXuat;
    private Date ngayNhapKho;
    private String errorMessage;
    private String successMessage;

    public AddHangHoaOutPutDTO(int maHang, String tenHang, int soLuongTon, double donGia, int loaiHangId, double phiVAT, Date ngaySanXuat, Date ngayHetHan, String nhaCungCap, int thoiGianBaoHanh, double congSuat, String nhaSanXuat, Date ngayNhapKho, String errorMessage, String successMessage) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.loaiHangId = loaiHangId;
        this.phiVAT = phiVAT;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
        this.errorMessage = errorMessage;
        this.successMessage = successMessage;
    }

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}
