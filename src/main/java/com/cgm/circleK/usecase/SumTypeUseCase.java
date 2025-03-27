package com.cgm.circleK.usecase;

import com.cgm.circleK.dto.SumTypeOutputDTO;
import com.cgm.circleK.dto.SumTypeInputDTO;

public class SumTypeUseCase implements SumTypeInPutBoundary {
    private SumTypeDBBoundary dbBoundary;
    private SumTypeOutPutBoundary outputBoundary;

    public SumTypeUseCase(SumTypeDBBoundary dbBoundary, SumTypeOutPutBoundary outputBoundary) {
        this.dbBoundary = dbBoundary;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void calculateTotalQuantity(SumTypeInputDTO inputDTO) {
        String category = inputDTO.getCategoryName();
        int totalQuantity = dbBoundary.getTotalQuantityByCategory(category);

        SumTypeOutputDTO outputDTO;
        if (totalQuantity == -1) { 
            outputDTO = new SumTypeOutputDTO(totalQuantity);
        } else {
            outputDTO = new SumTypeOutputDTO(totalQuantity);
        }

        outputBoundary.presentTotalQuantity(outputDTO);
    }

    public void setOutputBoundary(SumTypeOutPutBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
}
