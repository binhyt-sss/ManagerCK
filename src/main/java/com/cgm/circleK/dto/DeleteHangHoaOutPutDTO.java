package com.cgm.circleK.dto;

public class DeleteHangHoaOutPutDTO {
    private final boolean success;
    private final String errorMessage;

    public DeleteHangHoaOutPutDTO(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
} 