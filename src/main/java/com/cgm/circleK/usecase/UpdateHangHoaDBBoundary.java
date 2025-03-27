package com.cgm.circleK.usecase;

import com.cgm.circleK.dto.UpdateHangHoaInPutDTO;
import com.cgm.circleK.entity.HangHoa;

public interface UpdateHangHoaDBBoundary {
    HangHoa updateHangHoa(UpdateHangHoaInPutDTO updateHangHoaInPutDTO) throws Exception;
} 