package com.cgm.circleK.ui;

import com.cgm.circleK.dto.UpdateHangHoaInPutDTO;
import com.cgm.circleK.usecase.UpdateHangHoaInPutBoundary;

public class UpdateHangHoaController {
    private final UpdateHangHoaInPutBoundary updateHangHoaInPutBoundary;

    public UpdateHangHoaController(UpdateHangHoaInPutBoundary updateHangHoaInPutBoundary) {
        this.updateHangHoaInPutBoundary = updateHangHoaInPutBoundary;
    }

    public void execute(UpdateHangHoaInPutDTO updateHangHoaInPutDTO) {
        updateHangHoaInPutBoundary.execute(updateHangHoaInPutDTO);
    }
} 