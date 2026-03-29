package com.tailorapp.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class CreateBookingRequest {

    @NotNull(message = "userId is required")
    private Long userId;

    private Long tailorId;

    @NotNull(message = "addressId is required")
    private Long addressId;

    private Long measurementId;

    @NotNull(message = "bookingDate is required")
    private LocalDate bookingDate;

    private LocalTime bookingTime;

    private String notes;

    private List<Long> cartItemIds;
}
