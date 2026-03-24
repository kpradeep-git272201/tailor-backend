package com.tailorapp.booking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class BookingDTO {

    private Long bookingId;
    private Long userId;
    private Long tailorId;
    private Long addressId;
    private Long measurementId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String status;
    private BigDecimal totalAmount;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
