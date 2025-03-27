package com.cgm.circleK.ui;

import com.cgm.circleK.usecase.DeleteHangHoaOutPutBoundary;
import com.cgm.circleK.dto.DeleteHangHoaOutPutDTO;

import javax.swing.JOptionPane;

public class DeleteHangHoaPresenter implements DeleteHangHoaOutPutBoundary {

    @Override
    public void present(DeleteHangHoaOutPutDTO deleteHangHoaOutPutDTO) {
        if (deleteHangHoaOutPutDTO.isSuccess()) {
            JOptionPane.showMessageDialog(null, "Product deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String errorMessage = deleteHangHoaOutPutDTO.getErrorMessage();
            JOptionPane.showMessageDialog(null, "Error deleting product: " + (errorMessage != null ? errorMessage : "Unknown error"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
