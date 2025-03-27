package com.cgm.circleK.dto;

public class CheckHangHoaOutPutDTO {
    private int maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    private int loaiHangId;
    private double phiVAT;
    private String ngaySanXuat;
    private String ngayHetHan;
    private String nhaCungCap;
    private Integer thoiGianBaoHanh;
    private Double congSuatKW;
    private String nhaSanXuat;
    private String ngayNhapKho;
    private String errorMessage;

    // Constructor
    public CheckHangHoaOutPutDTO(int maHang, String tenHang, int soLuongTon, double donGia, int loaiHangId, double phiVAT, String ngaySanXuat, String ngayHetHan, String nhaCungCap, Integer thoiGianBaoHanh, Double congSuatKW, String nhaSanXuat, String ngayNhapKho, String errorMessage) {
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
        this.congSuatKW = congSuatKW;
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
        this.errorMessage = errorMessage;
    }

    // Getter methods (có thể thêm setter nếu cần)
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
        return phiVAT;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public Integer getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public Double getCongSuatKW() {
        return congSuatKW;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public String getNgayNhapKho() {
        return ngayNhapKho;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
