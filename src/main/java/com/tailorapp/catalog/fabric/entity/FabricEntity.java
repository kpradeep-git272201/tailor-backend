package com.tailorapp.catalog.fabric.entity;

import com.tailorapp.catalog.fabric_category.entity.FabricCategory;
import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fabrics", schema = DatabaseConstants.TAILOR)
public class FabricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fabric_id")
    private Long fabricId;
    @Column(name = "name", nullable = false, length = 100)
    private String fabricName;
    @Column(name = "fabric_category_id", nullable = false)
    private Integer fabricCategoryId;
    @Transient
    private BigDecimal pricePerMeter;
    @Column(name = "stock_qty")
    private Integer stockQty;
    @Column(name = "active_flag")
    private boolean isActive;
    @Column(name = "is_deleted")
    private char isDeleted;
    @Column(name = "image_path")
    private String imagePath;

    @Transient
    private Long priceId;


    public FabricEntity(){}

    public FabricEntity(Long fabricId, String fabricName, Integer fabricCategoryId, BigDecimal pricePerMeter, Integer stockQty, boolean isActive, char isDeleted, String imagePath, Long priceId) {
        this.fabricId = fabricId;
        this.fabricName = fabricName;
        this.fabricCategoryId = fabricCategoryId;
        this.pricePerMeter = pricePerMeter;
        this.stockQty = stockQty;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.imagePath = imagePath;
        this.priceId = priceId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public char getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(char isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }
}
