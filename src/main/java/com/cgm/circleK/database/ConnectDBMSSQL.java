package com.cgm.circleK.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDBMSSQL {
    private static final String CONNECTION_URL = "jdbc:sqlserver://DESKTOP-9BAJ70V\\SQLEXPRESS;;databaseName=QuanLySanPham;integratedSecurity=true;TrustServerCertificate=True;Trusted_Connection=true";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL);
    }
        public ResultSet getProductResultSet() throws SQLException {
        String query = "SELECT hh.MaHang, hh.TenHang, hh.SoLuongTon, hh.DonGia, lh.TenLoai AS LoaiHang, hh.PhiVAT " +
                       "FROM HangHoa hh " +
                       "JOIN LoaiHang lh ON hh.LoaiHangId = lh.LoaiHangId";
        Connection connection = getConnection();
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return stmt.executeQuery(query);
    }

}
