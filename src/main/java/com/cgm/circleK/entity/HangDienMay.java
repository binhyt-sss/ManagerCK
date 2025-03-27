package com.cgm.circleK.entity;

public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(String tenHang, int soLuongTon, double donGia, int loaiHangId, int thoiGianBaoHanh, double congSuat) {
        super(tenHang, soLuongTon, donGia, 2);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }
    public HangDienMay(int maHang,String tenHang, int soLuongTon, double donGia, int loaiHangId, int thoiGianBaoHanh, double congSuatKW) {
        super(maHang,tenHang, soLuongTon, donGia, 2);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuatKW;
    }

    @Override
    public double tinhVat() {
        return donGia * 0.10;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public double getCongSuat() {
        return congSuat;
    }
}
 