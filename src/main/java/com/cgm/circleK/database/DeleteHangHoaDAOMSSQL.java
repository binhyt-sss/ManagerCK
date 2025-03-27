package com.cgm.circleK.database;

import com.cgm.circleK.usecase.DeleteHangHoaDBBoundary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteHangHoaDAOMSSQL extends ConnectDBMSSQL implements DeleteHangHoaDBBoundary {

    @Override
    public boolean deleteHangHoa(int maHang) {

        String deleteHangHoaSql = "DELETE FROM HangHoa WHERE MaHang = ?";

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false); // Bắt đầu transaction

            try (
                 
                
                 PreparedStatement deleteHangHoaStmt = connection.prepareStatement(deleteHangHoaSql)) {

                // Xóa bản ghi trong HangHoa
                deleteHangHoaStmt.setInt(1, maHang);
                int affectedRows = deleteHangHoaStmt.executeUpdate();

                connection.commit(); // Commit transaction
                return affectedRows > 0;
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean exists(int maHang) {
        String sql = "SELECT COUNT(*) FROM HangHoa WHERE MaHang = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maHang);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
