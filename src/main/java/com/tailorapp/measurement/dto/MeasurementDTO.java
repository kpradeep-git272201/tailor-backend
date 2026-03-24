package com.tailorapp.measurement.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
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
}
