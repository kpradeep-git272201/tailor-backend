package com.tailorapp.catalog.cart.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CartDTO {

    private Long cartId;
    private Long userId;
    private Long articleId;
    private Long fabricId;
    private Integer quantity;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
