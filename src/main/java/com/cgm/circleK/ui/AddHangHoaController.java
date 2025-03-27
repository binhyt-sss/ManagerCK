package com.cgm.circleK.ui;

import com.cgm.circleK.dto.AddHangHoaInPutDTO;
import com.cgm.circleK.usecase.AddHangHoaInPutBoundary;

public class AddHangHoaController {
    private final AddHangHoaInPutBoundary addHangHoaInPutBoundary;

    public AddHangHoaController(AddHangHoaInPutBoundary addHangHoaInPutBoundary) {
        this.addHangHoaInPutBoundary = addHangHoaInPutBoundary;
    }

    public void addHangHoa(AddHangHoaInPutDTO addHangHoaInPutDTO) {
        addHangHoaInPutBoundary.execute(addHangHoaInPutDTO);
    }
}
