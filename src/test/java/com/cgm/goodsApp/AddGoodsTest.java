// package com.cgm.goodsApp;

// import static org.junit.Assert.assertEquals;

// import java.util.Calendar;
// import java.util.Date;

// import org.junit.Before;
// import org.junit.Test;

// import com.cgm.circleK.database.AddHangHoaDAOMSSQL;
// import com.cgm.circleK.ui.AddHangHoaPresenter;
// import com.cgm.circleK.usecase.AddHangHoaUseCase;
// import com.cgm.circleK.usecase.AddHangHoaInPutBoundary;
// import com.cgm.circleK.dto.AddHangHoaInPutDTO;
// import com.cgm.circleK.dto.AddHangHoaOutPutDTO;

// public class AddGoodsTest {

//     private AddHangHoaDAOMSSQL database;
//     private AddHangHoaPresenter addHangHoaPresenter;
//     private AddHangHoaInPutBoundary addHangHoaUseCase;

//     @Before
//     public void setUp() {
//         database = new AddHangHoaDAOMSSQL();
//         addHangHoaPresenter = new AddHangHoaPresenter();
//         addHangHoaUseCase = new AddHangHoaUseCase(database, addHangHoaPresenter);
//     }

//     @Test
//     public void testAddThucPhamGoods() {
//         // Arrange
//         AddHangHoaInPutDTO inputDTO = ThucPhamGoodsInputData();
//         addHangHoaUseCase.execute(inputDTO);
//         AddHangHoaOutPutDTO addHangHoaOutPutDTO = addHangHoaPresenter.getAddHangHoaOutPutDTO();
//         assertEquals(inputDTO.getTenHang(), addHangHoaOutPutDTO.getTenHang());
//         assertEquals(inputDTO.getSoLuongTon(), addHangHoaOutPutDTO.getSoLuongTon());
//         assertEquals(inputDTO.getDonGia(), addHangHoaOutPutDTO.getDonGia(), 0.01);
//     }

//     private AddHangHoaInPutDTO ThucPhamGoodsInputData() {
//         Calendar calendar = Calendar.getInstance();
//         calendar.set(2023, Calendar.NOVEMBER, 13);
//         Date ngaySanXuat = new Date(calendar.getTimeInMillis());
//         calendar.set(2024, Calendar.NOVEMBER, 13);
//         Date ngayHetHan = new Date(calendar.getTimeInMillis());
//         return new AddHangHoaInPutDTO("apk", 1000, 10.0, 1, ngaySanXuat, ngayHetHan, "sss");
//     }
// }
