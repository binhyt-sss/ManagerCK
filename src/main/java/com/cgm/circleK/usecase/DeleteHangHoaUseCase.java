package com.cgm.circleK.usecase;

import com.cgm.circleK.dto.DeleteHangHoaInPutDTO;
import com.cgm.circleK.dto.DeleteHangHoaOutPutDTO;

public class DeleteHangHoaUseCase implements DeleteHangHoaInPutBoundary {
    private final DeleteHangHoaDBBoundary deleteHangHoaDBBoundary;
    private final DeleteHangHoaOutPutBoundary deleteHangHoaOutPutBoundary;

    public DeleteHangHoaUseCase(DeleteHangHoaDBBoundary deleteHangHoaDBBoundary, DeleteHangHoaOutPutBoundary deleteHangHoaOutPutBoundary) {
        this.deleteHangHoaDBBoundary = deleteHangHoaDBBoundary;
        this.deleteHangHoaOutPutBoundary = deleteHangHoaOutPutBoundary;
    }

    @Override
    public void execute(DeleteHangHoaInPutDTO deleteHangHoaInPutDTO) {

        int maHang = deleteHangHoaInPutDTO.getMaHang();
        if (deleteHangHoaDBBoundary.exists(maHang)) {
            boolean success = deleteHangHoaDBBoundary.deleteHangHoa(maHang);
            String errorMessage = success ? null : "Failed to delete product. Please check the database constraints.";
            DeleteHangHoaOutPutDTO outputDTO = new DeleteHangHoaOutPutDTO(success, errorMessage);
            deleteHangHoaOutPutBoundary.present(outputDTO);
        } else {
            DeleteHangHoaOutPutDTO outputDTO = new DeleteHangHoaOutPutDTO(false, "Product ID does not exist.");
            deleteHangHoaOutPutBoundary.present(outputDTO);
        }
    }
} 