package com.cgm.circleK.ui;

import com.cgm.circleK.dto.AddHangHoaOutPutDTO;
import com.cgm.circleK.usecase.AddHangHoaOutPutBoundary;

import javax.swing.*;

public class AddHangHoaPresenter implements AddHangHoaOutPutBoundary {
    private final JFrame parentFrame;

    public AddHangHoaPresenter(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    @Override
    public void present(AddHangHoaOutPutDTO addHangHoaOutPutDTO) {
        if (addHangHoaOutPutDTO.getErrorMessage() != null) {
            JOptionPane.showMessageDialog(parentFrame, "Error adding product: " + addHangHoaOutPutDTO.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String successMessage = addHangHoaOutPutDTO.getSuccessMessage();
            JOptionPane.showMessageDialog(parentFrame, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
