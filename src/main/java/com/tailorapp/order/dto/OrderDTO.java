package com.tailorapp.order.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDTO {

    private Long orderId;
    private Long bookingId;
    private Long userId;
    private String orderNumber;
    private String status;
    private BigDecimal totalAmount;
    private String paymentStatus;
    private Long deliveryAddressId;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime actualDeliveryDate;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
