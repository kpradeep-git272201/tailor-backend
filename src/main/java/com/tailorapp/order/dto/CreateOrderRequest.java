package com.tailorapp.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderRequest {

    @NotNull(message = "bookingId is required")
    private Long bookingId;

    private String notes;
}
