package com.tailorapp.measurement.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
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
}
