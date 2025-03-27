package com.cgm.circleK.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cgm.circleK.usecase.SumTypeDBBoundary;

public class SumTypeDAOMSSQL implements SumTypeDBBoundary {
    
    private final Connection connection;

    public SumTypeDAOMSSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int getTotalQuantityByCategory(String categoryName) {
        String sql = "SELECT SUM(SoLuongTon) AS TotalQuantity FROM HangHoa hh " +
                     "JOIN LoaiHang lh ON hh.LoaiHangId = lh.LoaiHangId WHERE lh.TenLoai = ?";
        int totalQuantity = -1; 

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalQuantity = rs.getInt("TotalQuantity");
                if (rs.wasNull()) { 
                    totalQuantity = 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tính tổng số lượng theo loại: " + e.getMessage());
        }

        return totalQuantity;
    }

    
    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT TenLoai FROM LoaiHang";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("TenLoai"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi truy vấn danh sách loại hàng: " + e.getMessage());
        }

        return categories;
    }
}
