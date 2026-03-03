package com.tailorapp.catalog.cart.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddToCartRequest {

    @NotNull(message = "userId is required")
    private Long userId;

    private Long articleId;

    private Long fabricId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity = 1;

    private BigDecimal price;
}
