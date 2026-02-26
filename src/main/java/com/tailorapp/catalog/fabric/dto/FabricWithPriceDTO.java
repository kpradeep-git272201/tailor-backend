package com.tailorapp.catalog.fabric.dto;

import java.math.BigDecimal;

public class FabricWithPriceDTO {
    private Long fabricId;
    private String fabricName;
    private Integer fabricCategoryId;
    private BigDecimal pricePerMeter;
    private Integer stockQty;
    private Boolean isActive;
    private Character isDeleted;
    private String imagePath;
    private String categoryName;
    private String categoryDescription;
    public FabricWithPriceDTO(
            Long fabricId,
            String fabricName,
            Integer fabricCategoryId,
            BigDecimal pricePerMeter,
            Integer stockQty,
            Boolean isActive,
            Character isDeleted,
            String imagePath,
            String categoryName,
            String categoryDescription
    ) {

        this.fabricId = fabricId;
        this.fabricName = fabricName;
        this.fabricCategoryId = fabricCategoryId;
        this.pricePerMeter = pricePerMeter;
        this.stockQty = stockQty;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.imagePath = imagePath;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getFabricId() {
        return fabricId;
    }

    public void setFabricId(Long fabricId) {
        this.fabricId = fabricId;
    }

    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }

    public Integer getFabricCategoryId() {
        return fabricCategoryId;
    }

    public void setFabricCategoryId(Integer fabricCategoryId) {
        this.fabricCategoryId = fabricCategoryId;
    }

    public BigDecimal getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(BigDecimal pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Character getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Character deleted) {
        isDeleted = deleted;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
