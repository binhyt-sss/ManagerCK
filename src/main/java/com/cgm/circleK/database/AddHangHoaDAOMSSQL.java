package com.cgm.circleK.database;

import com.cgm.circleK.entity.HangHoa;
import com.cgm.circleK.entity.HangThucPham;
import com.cgm.circleK.entity.HangDienMay;
import com.cgm.circleK.entity.HangSanhSu;
import com.cgm.circleK.usecase.AddHangHoaDBBoundary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class AddHangHoaDAOMSSQL extends ConnectDBMSSQL implements AddHangHoaDBBoundary {

    @Override
    public int addHangHoa(HangHoa hangHoa) {
        String sql = "INSERT INTO HangHoa (TenHang, SoLuongTon, DonGia, LoaiHangId, PhiVAT, NgaySanXuat, NgayHetHan, NhaCungCap, ThoiGianBaoHanh, CongSuatKW, NhaSanXuat, NgayNhapKho) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, hangHoa.getTenHang());
            preparedStatement.setInt(2, hangHoa.getSoLuongTon());
            preparedStatement.setDouble(3, hangHoa.getDonGia());
            preparedStatement.setInt(4, hangHoa.getLoaiHangId());
            preparedStatement.setDouble(5, hangHoa.getPhiVAT());

            if (hangHoa instanceof HangThucPham) {
                HangThucPham thucPham = (HangThucPham) hangHoa;
                preparedStatement.setDate(6, new java.sql.Date(thucPham.getNgaySanXuat().getTime()));
                preparedStatement.setDate(7, new java.sql.Date(thucPham.getNgayHetHan().getTime()));
                preparedStatement.setString(8, thucPham.getNhaCungCap());
                preparedStatement.setNull(9, Types.INTEGER);
                preparedStatement.setNull(10, Types.DOUBLE);
                preparedStatement.setNull(11, Types.VARCHAR);
                preparedStatement.setNull(12, Types.DATE);
            } else if (hangHoa instanceof HangDienMay) {
                HangDienMay dienMay = (HangDienMay) hangHoa;
                preparedStatement.setNull(6, Types.DATE);
                preparedStatement.setNull(7, Types.DATE);
                preparedStatement.setNull(8, Types.VARCHAR);
                preparedStatement.setInt(9, dienMay.getThoiGianBaoHanh());
                preparedStatement.setDouble(10, dienMay.getCongSuat());
                preparedStatement.setNull(11, Types.VARCHAR);
                preparedStatement.setNull(12, Types.DATE);
            } else if (hangHoa instanceof HangSanhSu) {
                HangSanhSu sanhSu = (HangSanhSu) hangHoa;
                preparedStatement.setNull(6, Types.DATE);
                preparedStatement.setNull(7, Types.DATE);
                preparedStatement.setNull(8, Types.VARCHAR);
                preparedStatement.setNull(9, Types.INTEGER);
                preparedStatement.setNull(10, Types.DOUBLE);
                preparedStatement.setString(11, sanhSu.getNhaSanXuat());
                preparedStatement.setDate(12, new java.sql.Date(sanhSu.getNgayNhapKho().getTime()));
            }

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating hangHoa failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating hangHoa failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    

    @Override
    public List<String> getLoaiHangList() {
        List<String> loaiHangList = new ArrayList<>();
        String sql = "SELECT TenLoai FROM LoaiHang ORDER BY LoaiHangId";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                loaiHangList.add(resultSet.getString("TenLoai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loaiHangList;
    }
    public DefaultTableModel loadProductData() {
        DefaultTableModel tableModel = null;

        try (ResultSet rs = getProductResultSet()) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Get column names
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            // Get data
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();

            Object[][] data = new Object[rowCount][columnCount];
            int rowIndex = 0;
            while (rs.next()) {
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    data[rowIndex][colIndex - 1] = rs.getObject(colIndex);
                }
                rowIndex++;
            }

            tableModel = new DefaultTableModel(data, columnNames);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableModel;
    }
    
}


