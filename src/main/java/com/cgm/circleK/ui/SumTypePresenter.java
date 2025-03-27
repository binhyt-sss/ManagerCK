package com.cgm.circleK.ui;
import com.cgm.circleK.usecase.SumTypeOutPutBoundary;
import com.cgm.circleK.dto.SumTypeOutputDTO;

public class SumTypePresenter implements SumTypeOutPutBoundary {
    private  SumTypeView view;

    public SumTypePresenter(SumTypeView view) {
        this.view = view;
    }
    public void setView(SumTypeView view) {
        this.view = view;
    }
    @Override
    public void presentTotalQuantity(SumTypeOutputDTO outputDTO) {
        String message;
        if (outputDTO.getTotalQuantity() == -1) {
            message = "Loại hàng không tồn tại hoặc không có sản phẩm nào thuộc loại này.";
        } else {
            message = "Tổng số lượng sản phẩm: " + outputDTO.getTotalQuantity();
        }
        view.displayMessage(message);
    }    
}
