package com.cgm.circleK.usecase;

import java.util.List;

import com.cgm.circleK.database.CheckHangHoaDAOMSSQL;

public class CheckHangHoaHetHanUseCase {

   
    private final CheckHangHoaDAOMSSQL checkHangHoaDAOMSSQL;

    
    public CheckHangHoaHetHanUseCase() {
        this.checkHangHoaDAOMSSQL = new CheckHangHoaDAOMSSQL();
    }

    
    public List<String[]> getExpiringProducts() {

        return checkHangHoaDAOMSSQL.getExpiringProducts();
    }
}
