package com.tailorapp.payment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePaymentRequest {

    @NotNull(message = "orderId is required")
    private Long orderId;

    @NotNull(message = "amount is required")
    private BigDecimal amount;

    private String paymentGateway = "RAZORPAY";

    private String currency = "INR";
}
