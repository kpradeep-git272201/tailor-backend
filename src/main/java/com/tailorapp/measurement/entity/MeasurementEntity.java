package com.tailorapp.measurement.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurements", schema = DatabaseConstants.TAILOR)
public class MeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Long measurementId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "measurement_name", length = 100)
    private String measurementName;

    @Column(name = "chest", precision = 5, scale = 2)
    private BigDecimal chest;

    @Column(name = "waist", precision = 5, scale = 2)
    private BigDecimal waist;

    @Column(name = "hip", precision = 5, scale = 2)
    private BigDecimal hip;

    @Column(name = "shoulder", precision = 5, scale = 2)
    private BigDecimal shoulder;

    @Column(name = "sleeve_length", precision = 5, scale = 2)
    private BigDecimal sleeveLength;

    @Column(name = "shirt_length", precision = 5, scale = 2)
    private BigDecimal shirtLength;

    @Column(name = "neck", precision = 5, scale = 2)
    private BigDecimal neck;

    @Column(name = "inseam", precision = 5, scale = 2)
    private BigDecimal inseam;

    @Column(name = "outseam", precision = 5, scale = 2)
    private BigDecimal outseam;

    @Column(name = "thigh", precision = 5, scale = 2)
    private BigDecimal thigh;

    @Column(name = "calf", precision = 5, scale = 2)
    private BigDecimal calf;

    @Column(name = "ankle", precision = 5, scale = 2)
    private BigDecimal ankle;

    @Column(name = "unit", length = 10)
    private String unit = "cm";

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "is_default")
    private Boolean isDefault = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

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

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
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
