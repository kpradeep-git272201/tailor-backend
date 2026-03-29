package com.tailorapp.payment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VerifyPaymentRequest {

    @NotBlank(message = "gatewayOrderId is required")
    private String gatewayOrderId;

    @NotBlank(message = "gatewayPaymentId is required")
    private String gatewayPaymentId;

    @NotBlank(message = "gatewaySignature is required")
    private String gatewaySignature;
}
