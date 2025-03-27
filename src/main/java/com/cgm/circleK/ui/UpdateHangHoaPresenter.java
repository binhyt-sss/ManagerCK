package com.cgm.circleK.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.cgm.circleK.dto.UpdateHangHoaOutPutDTO;
import com.cgm.circleK.usecase.UpdateHangHoaOutPutBoundary;

public class UpdateHangHoaPresenter implements UpdateHangHoaOutPutBoundary {
    private JFrame view = null;
    
        public UpdateHangHoaPresenter() {
            this.view = view;
    }

    @Override
    public void present(UpdateHangHoaOutPutDTO updateHangHoaOutPutDTO) {
        if (updateHangHoaOutPutDTO.getErrorMessage() != null) {
            JOptionPane.showMessageDialog(view, "Error updating product: " + updateHangHoaOutPutDTO.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Product updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}