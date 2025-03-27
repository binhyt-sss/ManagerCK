package com.cgm.circleK.dto;

public class SumTypeInputDTO {
    private final String categoryName;

    public SumTypeInputDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
