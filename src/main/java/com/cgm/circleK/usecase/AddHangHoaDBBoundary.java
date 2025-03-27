package com.cgm.circleK.usecase;

import com.cgm.circleK.entity.HangHoa;
import java.util.List;

public interface AddHangHoaDBBoundary {
    int addHangHoa(HangHoa hangHoa);
    List<String> getLoaiHangList();
}
