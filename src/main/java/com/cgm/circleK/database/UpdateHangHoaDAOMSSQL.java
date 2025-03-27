package com.cgm.circleK.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cgm.circleK.dto.UpdateHangHoaInPutDTO;
import com.cgm.circleK.entity.HangDienMay;
import com.cgm.circleK.entity.HangHoa;
import com.cgm.circleK.entity.HangSanhSu;
import com.cgm.circleK.entity.HangThucPham;
import com.cgm.circleK.usecase.UpdateHangHoaDBBoundary;

public class UpdateHangHoaDAOMSSQL extends ConnectDBMSSQL implements UpdateHangHoaDBBoundary {

    public static HangHoa findProductById(int maHang) throws SQLException {
        String sql = "SELECT * FROM HangHoa WHERE MaHang = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, maHang);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                    String tenHang = rs.getString("TenHang");
                    int soLuongTon = rs.getInt("SoLuongTon");
                    double donGia = rs.getDouble("DonGia");
                    int loaiHangId = rs.getInt("LoaiHangId");
                    
                    switch (loaiHangId) {
                        case 1:
                            return new HangThucPham(
                                maHang,
                                tenHang,
                                soLuongTon,
                                donGia,
                                loaiHangId,
                                rs.getDate("NgaySanXuat"),
                                rs.getDate("NgayHetHan"),
                                rs.getString("NhaCungCap")
                            );
                        case 2:
                            return new HangDienMay(
                                maHang,
                                tenHang,
                                soLuongTon,
                                donGia,
                                loaiHangId,
                                rs.getInt("ThoiGianBaoHanh"),
                                rs.getDouble("CongSuatKW")
                            );
                        case 3:
                            return new HangSanhSu(
                                maHang,
                                tenHang,
                                soLuongTon,
                                donGia,
                                loaiHangId,
                                rs.getString("NhaSanXuat"),
                                rs.getDate("NgayNhapKho")
                            );
                        default:
                            throw new SQLException("Unknown product type: " + loaiHangId);
                    }
                } else {
                    throw new SQLException("Product not found with maHang: " + maHang);
                }
            }
        }
    }

    @Override
public HangHoa updateHangHoa(UpdateHangHoaInPutDTO updateHangHoaInPutDTO) throws Exception {
    String sql;

    // Xây dựng câu lệnh SQL theo LoaiHangId
    switch (updateHangHoaInPutDTO.getLoaiHangId()) {
        case 1 -> {
            sql = "UPDATE HangHoa SET tenHang = ?, soLuongTon = ?, donGia = ?, loaiHangId = ?, ngaySanXuat = ?, ngayHetHan = ?, nhaCungCap = ? WHERE maHang = ?";
        }
        case 2 -> {
            sql = "UPDATE HangHoa SET tenHang = ?, soLuongTon = ?, donGia = ?, loaiHangId = ?, thoiGianBaoHanh = ?, congSuatKW = ? WHERE maHang = ?";
        }
        case 3 -> {
            sql = "UPDATE HangHoa SET tenHang = ?, soLuongTon = ?, donGia = ?, loaiHangId = ?, nhaSanXuat = ?, ngayNhapKho = ? WHERE maHang = ?";
        }
        default -> throw new IllegalArgumentException("Invalid product type: " + updateHangHoaInPutDTO.getLoaiHangId());
    }

    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Set các tham số tùy theo LoaiHangId
        switch (updateHangHoaInPutDTO.getLoaiHangId()) {
            case 1 -> {
                stmt.setString(1, updateHangHoaInPutDTO.getTenHang());
                stmt.setInt(2, updateHangHoaInPutDTO.getSoLuongTon());
                stmt.setDouble(3, updateHangHoaInPutDTO.getDonGia());
                stmt.setInt(4, updateHangHoaInPutDTO.getLoaiHangId());
                stmt.setDate(5, new java.sql.Date(updateHangHoaInPutDTO.getNgaySanXuat().getTime()));
                stmt.setDate(6, new java.sql.Date(updateHangHoaInPutDTO.getNgayHetHan().getTime()));
                stmt.setString(7, updateHangHoaInPutDTO.getNhaCungCap());
                stmt.setInt(8, updateHangHoaInPutDTO.getMaHang());
            }
            case 2 -> {
                stmt.setString(1, updateHangHoaInPutDTO.getTenHang());
                stmt.setInt(2, updateHangHoaInPutDTO.getSoLuongTon());
                stmt.setDouble(3, updateHangHoaInPutDTO.getDonGia());
                stmt.setInt(4, updateHangHoaInPutDTO.getLoaiHangId());
                stmt.setInt(5, updateHangHoaInPutDTO.getThoiGianBaoHanh());
                stmt.setDouble(6, updateHangHoaInPutDTO.getCongSuatKW());
                stmt.setInt(7, updateHangHoaInPutDTO.getMaHang());
            }
            case 3 -> {
                stmt.setString(1, updateHangHoaInPutDTO.getTenHang());
                stmt.setInt(2, updateHangHoaInPutDTO.getSoLuongTon());
                stmt.setDouble(3, updateHangHoaInPutDTO.getDonGia());
                stmt.setInt(4, updateHangHoaInPutDTO.getLoaiHangId());
                stmt.setString(5, updateHangHoaInPutDTO.getNhaSanXuat());
                stmt.setDate(6, new java.sql.Date(updateHangHoaInPutDTO.getNgayNhapKho().getTime()));
                stmt.setInt(7, updateHangHoaInPutDTO.getMaHang());
            }
        }

        // Thực thi truy vấn
        int affectedRows = stmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Updating product failed, no rows affected.");
        }

        // Trả về đối tượng HangHoa đã được cập nhật
        return findProductById(updateHangHoaInPutDTO.getMaHang());
    } catch (SQLException e) {
        throw new Exception("Error updating product in database", e);
    }
}

}
