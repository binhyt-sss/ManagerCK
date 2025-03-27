package com.cgm.circleK.dto;

public class UpdateHangHoaOutPutDTO {
    private int maHang;
    private String errorMessage;

    public UpdateHangHoaOutPutDTO(int maHang, String errorMessage) {
        this.maHang = maHang;
        this.errorMessage = errorMessage;
    }

    // Getters
    public int getMaHang() {
        return maHang;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    // Setters
    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
} 