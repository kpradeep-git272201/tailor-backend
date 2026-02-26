package com.tailorapp.catalog.fabric.dto;



import java.math.BigDecimal;

public class FabricDTO {
    private Long fabricId;
    private String fabricName;
    private Integer fabricCategoryId;
    private BigDecimal pricePerMeter;
    private Integer stockQty;
    private Boolean isActive;
    private Character isDeleted;
    private String imagePat;

    private String categoryName;
    private String categoryDescription;
    private String categoryImage;
    private String fabricImage;


    public FabricDTO() {}

    public FabricDTO(Long fabricId, String fabricName, Integer fabricCategoryId, BigDecimal pricePerMeter, Integer stockQty, Boolean isActive, Character isDeleted, String imagePat) {
        this.fabricId = fabricId;
        this.fabricName = fabricName;
        this.fabricCategoryId = fabricCategoryId;
        this.pricePerMeter = pricePerMeter;
        this.stockQty = stockQty;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.imagePat = imagePat;
    }

    public FabricDTO(Long fabricCategoryId, String categoryName, String categoryDescription, String categoryImage, Long fabricId, String fabricName, Integer stockQty, Boolean isActive, Character isDeleted, String fabricImage) {

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

    public String getFabricImage() {
        return fabricImage;
    }

    public void setFabricImage(String fabricImage) {
        this.fabricImage = fabricImage;
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

    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getImagePat() {
        return imagePat;
    }

    public void setImagePat(String imagePat) {
        this.imagePat = imagePat;
    }
}