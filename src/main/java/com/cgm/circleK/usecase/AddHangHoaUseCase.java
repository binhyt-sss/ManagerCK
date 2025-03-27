package com.cgm.circleK.usecase;

import com.cgm.circleK.dto.AddHangHoaInPutDTO;
import com.cgm.circleK.dto.AddHangHoaOutPutDTO;
import com.cgm.circleK.entity.HangHoa;
import com.cgm.circleK.entity.HangDienMay;
import com.cgm.circleK.entity.HangSanhSu;
import com.cgm.circleK.entity.HangThucPham;
import java.util.List;

public class AddHangHoaUseCase implements AddHangHoaInPutBoundary {
    private final AddHangHoaDBBoundary addHangHoaDBBoundary;
    private final AddHangHoaOutPutBoundary addHangHoaOutPutBoundary;

    public AddHangHoaUseCase(AddHangHoaDBBoundary addHangHoaDBBoundary, AddHangHoaOutPutBoundary addHangHoaOutPutBoundary) {
        this.addHangHoaDBBoundary = addHangHoaDBBoundary;
        this.addHangHoaOutPutBoundary = addHangHoaOutPutBoundary;
    }

    @Override
    public void execute(AddHangHoaInPutDTO addHangHoaInPutDTO) {
        try {
            validate(addHangHoaInPutDTO);
    
            HangHoa hangHoa = createHangHoa(addHangHoaInPutDTO);
            int maHang = addHangHoaDBBoundary.addHangHoa(hangHoa);
            double phiVAT = hangHoa.getPhiVAT();
    
            AddHangHoaOutPutDTO addHangHoaOutPutDTO = createOutputDTO(addHangHoaInPutDTO, maHang, phiVAT);
            addHangHoaOutPutBoundary.present(addHangHoaOutPutDTO);
        } catch (IllegalArgumentException e) {
            AddHangHoaOutPutDTO outputDTO = new AddHangHoaOutPutDTO(0, null, 0, 0, 0, 0, null, null, null, 0, 0, null, null, e.getMessage(), null);
            addHangHoaOutPutBoundary.present(outputDTO);
        }
    }

    private HangHoa createHangHoa(AddHangHoaInPutDTO dto) {
        switch (dto.getLoaiHangId()) {
            case 1:
                return new HangThucPham(
                    dto.getTenHang(),
                    dto.getSoLuongTon(),
                    dto.getDonGia(),
                    dto.getLoaiHangId(),
                    dto.getNgaySanXuat(),
                    dto.getNgayHetHan(),
                    dto.getNhaCungCap()
                );
            case 2:
                return new HangDienMay(
                    dto.getTenHang(),
                    dto.getSoLuongTon(),
                    dto.getDonGia(),
                    dto.getLoaiHangId(),
                    dto.getThoiGianBaoHanh(),
                    dto.getCongSuat()
                );
            case 3:
                return new HangSanhSu(
                    dto.getTenHang(),
                    dto.getSoLuongTon(),
                    dto.getDonGia(),
                    dto.getLoaiHangId(),
                    dto.getNhaSanXuat(),
                    dto.getNgayNhapKho()
                );
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }

    private AddHangHoaOutPutDTO createOutputDTO(AddHangHoaInPutDTO dto, int maHang, double phiVAT) {
        String successMessage = "Product added successfully with ID: " + maHang;
        return new AddHangHoaOutPutDTO(
            maHang,
            dto.getTenHang(),
            dto.getSoLuongTon(),
            dto.getDonGia(),
            dto.getLoaiHangId(),
            phiVAT,
            dto.getNgaySanXuat(),
            dto.getNgayHetHan(),
            dto.getNhaCungCap(),
            dto.getThoiGianBaoHanh(),
            dto.getCongSuat(),
            dto.getNhaSanXuat(),
            dto.getNgayNhapKho(),
            null,
            successMessage
        );
    }

    private void validate(AddHangHoaInPutDTO dto) {
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
            case 1: // HangThucPham
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
                break;

            case 2: // HangDienMay
                if (dto.getThoiGianBaoHanh() < 0) {
                    throw new IllegalArgumentException("Warranty period cannot be negative");
                }
                if (dto.getCongSuat() <= 0) {
                    throw new IllegalArgumentException("Power must be greater than zero");
                }
                break;

            case 3: // HangSanhSu
                if (dto.getNhaSanXuat() == null || dto.getNhaSanXuat().isEmpty()) {
                    throw new IllegalArgumentException("Manufacturer cannot be empty");
                }
                if (dto.getNgayNhapKho() == null) {
                    throw new IllegalArgumentException("Entry date cannot be null");
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }
    public List<String> getLoaiHangList() {
        return addHangHoaDBBoundary.getLoaiHangList();
    }
}
