package com.cgm.circleK.ui;

import java.util.List;

import com.cgm.circleK.usecase.CheckHangHoaHetHanUseCase;

public class CheckHangHoaController {

    private CheckHangHoaHetHanUseCase checkHangHoaHetHan;

    public CheckHangHoaController(CheckHangHoaHetHanUseCase checkHangHoaHetHan) {
        this.checkHangHoaHetHan = checkHangHoaHetHan;
    }

    public List<String[]> getExpiringProducts() {
        return checkHangHoaHetHan.getExpiringProducts();
    }
}
