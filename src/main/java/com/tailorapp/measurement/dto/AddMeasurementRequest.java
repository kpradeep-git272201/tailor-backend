package com.tailorapp.measurement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddMeasurementRequest {

    @NotNull(message = "userId is required")
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

    private String unit = "cm";

    private String notes;

    private Boolean isDefault = false;
}
