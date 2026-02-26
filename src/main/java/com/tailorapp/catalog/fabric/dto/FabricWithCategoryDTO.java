package com.tailorapp.catalog.fabric.dto;

public class FabricWithCategoryDTO {

    // Category Info
    private Long fabricCategoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryImage;

    // Fabric Info
    private Long fabricId;
    private String fabricName;
    private Integer stockQty;
    private Boolean isActive;
    private Character isDeleted;
    private String fabricImage;

    public FabricWithCategoryDTO(
            Long fabricCategoryId,
            String categoryName,
            String categoryDescription,
            String categoryImage,
            Long fabricId,
            String fabricName,
            Integer stockQty,
            Boolean isActive,
            Character isDeleted,
            String fabricImage
    ) {
        this.fabricCategoryId = fabricCategoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryImage = categoryImage;
        this.fabricId = fabricId;
        this.fabricName = fabricName;
        this.stockQty = stockQty;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.fabricImage = fabricImage;
    }

    public Long getFabricCategoryId() {
        return fabricCategoryId;
    }

    public void setFabricCategoryId(Long fabricCategoryId) {
        this.fabricCategoryId = fabricCategoryId;
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

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
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

    public String getFabricImage() {
        return fabricImage;
    }

    public void setFabricImage(String fabricImage) {
        this.fabricImage = fabricImage;
    }
}
