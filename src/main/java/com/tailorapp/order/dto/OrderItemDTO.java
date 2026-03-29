package com.tailorapp.order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    private Long orderItemId;
    private Long orderId;
    private Long articleId;
    private Long fabricId;
    private Long measurementId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
    private String status;
}
