package com.cgm.circleK.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CheckHangHoaDAOMSSQL {

    @SuppressWarnings("CallToPrintStackTrace")
    public List<String[]> getExpiringProducts() {
        List<String[]> expiringProducts = new ArrayList<>();

        String query = "SELECT MaHang, TenHang, SoLuongTon, DonGia, NgayHetHan, PhiVAT " +
                       "FROM HangHoa " +
                       "WHERE DATEDIFF(DAY, GETDATE(), NgayHetHan) <= 7 " + 
                       "AND DATEDIFF(DAY, GETDATE(), NgayHetHan) > 0";

        try (Connection connection = ConnectDBMSSQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String maHang = resultSet.getString("MaHang");
                String tenHang = resultSet.getString("TenHang");
                String soLuongTon = resultSet.getString("SoLuongTon");
                String donGia = resultSet.getString("DonGia");
                String vat = resultSet.getString("PhiVAT");
                String ngayHetHan = resultSet.getString("NgayHetHan");

                expiringProducts.add(new String[]{maHang, tenHang, soLuongTon, donGia, vat, ngayHetHan});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return expiringProducts;
    }
}
