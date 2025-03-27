package com.cgm.circleK.usecase;

import com.cgm.circleK.dto.UpdateHangHoaInPutDTO;
import com.cgm.circleK.dto.UpdateHangHoaOutPutDTO;
import com.cgm.circleK.entity.HangDienMay;
import com.cgm.circleK.entity.HangHoa;
import com.cgm.circleK.entity.HangSanhSu;
import com.cgm.circleK.entity.HangThucPham;

public class UpdateHangHoaUseCase implements UpdateHangHoaInPutBoundary {
    private final UpdateHangHoaDBBoundary updateHangHoaDBBoundary;
    private final UpdateHangHoaOutPutBoundary updateHangHoaOutPutBoundary;

    public UpdateHangHoaUseCase(UpdateHangHoaDBBoundary updateHangHoaDBBoundary, UpdateHangHoaOutPutBoundary updateHangHoaOutPutBoundary) {
        this.updateHangHoaDBBoundary = updateHangHoaDBBoundary;
        this.updateHangHoaOutPutBoundary = updateHangHoaOutPutBoundary;
    }

    @Override
    public void execute(UpdateHangHoaInPutDTO updateHangHoaInPutDTO) {
        try {
            validate(updateHangHoaInPutDTO);

            HangHoa hangHoa;
            switch (updateHangHoaInPutDTO.getLoaiHangId()) {
                case 1 -> // HangThucPham
                    hangHoa = new HangThucPham(
                        updateHangHoaInPutDTO.getMaHang(),
                        updateHangHoaInPutDTO.getTenHang(),
                        updateHangHoaInPutDTO.getSoLuongTon(),
                        updateHangHoaInPutDTO.getDonGia(),
                        updateHangHoaInPutDTO.getLoaiHangId(),
                        updateHangHoaInPutDTO.getNgaySanXuat(),
                        updateHangHoaInPutDTO.getNgayHetHan(),
                        updateHangHoaInPutDTO.getNhaCungCap()
                    );
                case 2 -> // HangDienMay
                    hangHoa = new HangDienMay(
                        updateHangHoaInPutDTO.getMaHang(),
                        updateHangHoaInPutDTO.getTenHang(),
                        updateHangHoaInPutDTO.getSoLuongTon(),
                        updateHangHoaInPutDTO.getDonGia(),
                        updateHangHoaInPutDTO.getLoaiHangId(),
                        updateHangHoaInPutDTO.getThoiGianBaoHanh(),
                        updateHangHoaInPutDTO.getCongSuatKW()
                    );
                case 3 -> // HangSanhSu
                    hangHoa = new HangSanhSu(
                        updateHangHoaInPutDTO.getMaHang(),
                        updateHangHoaInPutDTO.getTenHang(),
                        updateHangHoaInPutDTO.getSoLuongTon(),
                        updateHangHoaInPutDTO.getDonGia(),
                        updateHangHoaInPutDTO.getLoaiHangId(),
                        updateHangHoaInPutDTO.getNhaSanXuat(),
                        updateHangHoaInPutDTO.getNgayNhapKho()
                    );
                default -> throw new IllegalArgumentException("Invalid product type.");
            }

            hangHoa = updateHangHoaDBBoundary.updateHangHoa(updateHangHoaInPutDTO);
            UpdateHangHoaOutPutDTO outputDTO = new UpdateHangHoaOutPutDTO(hangHoa.getMaHang(), null);
            updateHangHoaOutPutBoundary.present(outputDTO);
        } catch (Exception e) {
            UpdateHangHoaOutPutDTO outputDTO = new UpdateHangHoaOutPutDTO(0, e.getMessage());
            updateHangHoaOutPutBoundary.present(outputDTO);
        }
    }
    private void validate(UpdateHangHoaInPutDTO dto) {
        if (dto.getTenHang() == null || dto.getTenHang().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (dto.getSoLuongTon() < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        if (dto.getDonGia() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        switch (dto.getLoaiHangId()) {
            case 1 -> {
                // HangThucPham
                if (dto.getNgaySanXuat() == null) {
                    throw new IllegalArgumentException("Manufacture date cannot be null");
                }
                if (dto.getNgayHetHan() == null) {
                    throw new IllegalArgumentException("Expiration date cannot be null");
                }
                if (!dto.getNgayHetHan().after(dto.getNgaySanXuat())) {
                    throw new IllegalArgumentException("Expiration date must be after manufacture date");
                }
                if (dto.getNhaCungCap() == null || dto.getNhaCungCap().isEmpty()) {
                    throw new IllegalArgumentException("Supplier cannot be empty");
                }
            }
            case 2 -> {
                // HangDienMay
                if (dto.getThoiGianBaoHanh() < 0) {
                    throw new IllegalArgumentException("Warranty period cannot be negative");
                }
                if (dto.getCongSuatKW() <= 0) {
                    throw new IllegalArgumentException("Power must be greater than zero");
                }
            }
            case 3 -> {
                // HangSanhSu
                if (dto.getNhaSanXuat() == null || dto.getNhaSanXuat().isEmpty()) {
                    throw new IllegalArgumentException("Manufacturer cannot be empty");
                }
                if (dto.getNgayNhapKho() == null) {
                    throw new IllegalArgumentException("Entry date cannot be null");
                }
            }

            default -> throw new IllegalArgumentException("Invalid product type");
        }
    }
} 