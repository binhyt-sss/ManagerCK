package com.cgm.circleK.ui;

import com.cgm.circleK.dto.DeleteHangHoaInPutDTO;
import com.cgm.circleK.usecase.DeleteHangHoaInPutBoundary;

public class DeleteHangHoaController {
    private final DeleteHangHoaInPutBoundary deleteHangHoaInPutBoundary;

    public DeleteHangHoaController(DeleteHangHoaInPutBoundary deleteHangHoaInPutBoundary) {
        this.deleteHangHoaInPutBoundary = deleteHangHoaInPutBoundary;
    }

    public void execute(int maHang) {
        DeleteHangHoaInPutDTO inputDTO = new DeleteHangHoaInPutDTO(maHang);
        deleteHangHoaInPutBoundary.execute(inputDTO);
    }
} 