package com.cgm.circleK.ui;

import com.cgm.circleK.usecase.SumTypeInPutBoundary;
import com.cgm.circleK.dto.SumTypeInputDTO;

public class SumTypeController {
    private SumTypeInPutBoundary useCase;

    public SumTypeController(SumTypeInPutBoundary useCase) {
        this.useCase = useCase;
    }

    public void calculateTotalQuantity(SumTypeInputDTO inputDTO) {
        useCase.calculateTotalQuantity(inputDTO);
    }
}
