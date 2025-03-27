package com.cgm.circleK.ui;

import java.util.List;
import com.cgm.circleK.usecase.CheckHangHoaHetHanUseCase;

public class CheckHanghoaPresenter {

    private final CheckHangHoaHetHanView view;
    private final CheckHangHoaHetHanUseCase useCase;

    // Constructor
    public CheckHanghoaPresenter(CheckHangHoaHetHanView view, CheckHangHoaHetHanUseCase useCase) {
        this.view = view;
        this.useCase = useCase;
    }

    // Method to fetch and display expiring products
    public void fetchAndDisplayExpiringProducts() {
        try {
            List<String[]> expiringProducts = useCase.getExpiringProducts();
            view.displayProducts(expiringProducts);
        } catch (Exception e) {
            view.showError("Failed to load expiring products: " + e.getMessage());
        }
    }
}
