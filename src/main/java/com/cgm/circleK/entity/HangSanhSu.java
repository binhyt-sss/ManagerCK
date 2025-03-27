package com.cgm.circleK.entity;

import java.util.Date;

public class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private Date ngayNhapKho;

    public HangSanhSu(String tenHang, int soLuongTon, double donGia, int loaiHangId, String nhaSanXuat, Date ngayNhapKho) {
        super(tenHang, soLuongTon, donGia, 3);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }
    public HangSanhSu(int maHang, String tenHang, int soLuongTon, double donGia, int loaiHangId, String nhaSanXuat, Date ngayNhapKho) {
        super(maHang,tenHang, soLuongTon, donGia, 3);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }


    @Override
    public double tinhVat() {
        return donGia * 0.10;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
}
