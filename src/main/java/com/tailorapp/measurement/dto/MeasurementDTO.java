package com.tailorapp.measurement.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MeasurementDTO {

    private Long measurementId;
    private Long userId;
    private Long articleId;
    private String measurementName;
    private BigDecimal chest;
    private BigDecimal waist;
    private BigDecimal hip;
    private BigDecimal shoulder;
    private BigDecimal sleeveLength;
    private BigDecimal shirtLength;
    private BigDecimal neck;
    private BigDecimal inseam;
    private BigDecimal outseam;
    private BigDecimal thigh;
    private BigDecimal calf;
    private BigDecimal ankle;
    private String unit;
    private String notes;
    private Boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(Long measurementId) {
        this.measurementId = measurementId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getMeasurementName() {
        return measurementName;
    }

    public void setMeasurementName(String measurementName) {
        this.measurementName = measurementName;
    }

    public BigDecimal getChest() {
        return chest;
    }

    public void setChest(BigDecimal chest) {
        this.chest = chest;
    }

    public BigDecimal getWaist() {
        return waist;
    }

    public void setWaist(BigDecimal waist) {
        this.waist = waist;
    }

    public BigDecimal getHip() {
        return hip;
    }

    public void setHip(BigDecimal hip) {
        this.hip = hip;
    }

    public BigDecimal getShoulder() {
        return shoulder;
    }

    public void setShoulder(BigDecimal shoulder) {
        this.shoulder = shoulder;
    }

    public BigDecimal getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(BigDecimal sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public BigDecimal getShirtLength() {
        return shirtLength;
    }

    public void setShirtLength(BigDecimal shirtLength) {
        this.shirtLength = shirtLength;
    }

    public BigDecimal getNeck() {
        return neck;
    }

    public void setNeck(BigDecimal neck) {
        this.neck = neck;
    }

    public BigDecimal getInseam() {
        return inseam;
    }

    public void setInseam(BigDecimal inseam) {
        this.inseam = inseam;
    }

    public BigDecimal getOutseam() {
        return outseam;
    }

    public void setOutseam(BigDecimal outseam) {
        this.outseam = outseam;
    }

    public BigDecimal getThigh() {
        return thigh;
    }

    public void setThigh(BigDecimal thigh) {
        this.thigh = thigh;
    }

    public BigDecimal getCalf() {
        return calf;
    }

    public void setCalf(BigDecimal calf) {
        this.calf = calf;
    }

    public BigDecimal getAnkle() {
        return ankle;
    }

    public void setAnkle(BigDecimal ankle) {
        this.ankle = ankle;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
