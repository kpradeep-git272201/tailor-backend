package com.tailorapp.payment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDTO {

    private Long paymentId;
    private Long orderId;
    private Long userId;
    private String paymentGateway;
    private String transactionId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String paymentMethod;
    private String gatewayOrderId;
    private String gatewayPaymentId;
    private String failureReason;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
}
