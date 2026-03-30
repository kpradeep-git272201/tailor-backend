package com.tailorapp.payment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class VerifyPaymentRequest {

    @NotBlank(message = "gatewayOrderId is required")
    private String gatewayOrderId;

    @NotBlank(message = "gatewayPaymentId is required")
    private String gatewayPaymentId;

    @NotBlank(message = "gatewaySignature is required")
    private String gatewaySignature;

    public String getGatewayOrderId() {
        return gatewayOrderId;
    }

    public void setGatewayOrderId(String gatewayOrderId) {
        this.gatewayOrderId = gatewayOrderId;
    }

    public String getGatewayPaymentId() {
        return gatewayPaymentId;
    }

    public void setGatewayPaymentId(String gatewayPaymentId) {
        this.gatewayPaymentId = gatewayPaymentId;
    }

    public String getGatewaySignature() {
        return gatewaySignature;
    }

    public void setGatewaySignature(String gatewaySignature) {
        this.gatewaySignature = gatewaySignature;
    }
}
