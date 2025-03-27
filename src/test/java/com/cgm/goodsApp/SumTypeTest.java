package com.cgm.goodsApp;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cgm.circleK.database.SumTypeDAOMSSQL;
import com.cgm.circleK.dto.SumTypeOutputDTO;
import com.cgm.circleK.ui.SumTypePresenter;
import com.cgm.circleK.ui.SumTypeView;
import com.cgm.circleK.usecase.SumTypeDBBoundary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;

public class SumTypeTest {

    private SumTypeDBBoundary sumTypeDAO;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private SumTypePresenter sumTypePresenter; 
    private SumTypeView sumTypeView; 

    @BeforeEach
    void setUp() throws SQLException {
        
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);

        
        sumTypePresenter = mock(SumTypePresenter.class);
        sumTypeView = mock(SumTypeView.class);

        
        sumTypeDAO = new SumTypeDAOMSSQL(connection);

        
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        sumTypePresenter.setView(sumTypeView);
    }

    @Test
    void testGetTotalQuantityByCategory() throws SQLException {
        
        String categoryName = "ThucPham";
        int expectedTotalQuantity = 150;

        
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("TotalQuantity")).thenReturn(expectedTotalQuantity);
        when(resultSet.wasNull()).thenReturn(false);

        
        int totalQuantity = sumTypeDAO.getTotalQuantityByCategory(categoryName);

        
        assertEquals(expectedTotalQuantity, totalQuantity);

       
        verify(preparedStatement).setString(1, categoryName);
        verify(preparedStatement).executeQuery();
        
        System.out.println("Ten loai hang:" + categoryName +" So luong ton " + totalQuantity);
        
    }

    @Test
    void testGetTotalQuantityByCategory_InvalidCategory() throws SQLException {
        
        String invalidCategoryName = "LoaiHangKhongCo";

        
        when(resultSet.next()).thenReturn(false);  
        when(resultSet.getInt("TotalQuantity")).thenReturn(-1);  
        when(resultSet.wasNull()).thenReturn(true);  

        
        int totalQuantity = sumTypeDAO.getTotalQuantityByCategory(invalidCategoryName);
        assertEquals(-1, totalQuantity);

        SumTypeOutputDTO outputDTO = new SumTypeOutputDTO(-1);
        sumTypePresenter.presentTotalQuantity(outputDTO);

        verify(sumTypePresenter).presentTotalQuantity(outputDTO);
        

        verify(preparedStatement).setString(1, invalidCategoryName);
        verify(preparedStatement).executeQuery();

        System.out.println("Ten loai hang:" + invalidCategoryName + " So luong ton: " + totalQuantity);
    }
}
