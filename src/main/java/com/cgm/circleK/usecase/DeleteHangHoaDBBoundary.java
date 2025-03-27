package com.cgm.circleK.usecase;

public interface DeleteHangHoaDBBoundary {
    boolean deleteHangHoa(int maHang);
    boolean exists(int maHang);
} 