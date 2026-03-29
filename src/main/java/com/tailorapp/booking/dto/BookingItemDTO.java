package com.tailorapp.booking.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingItemDTO {

    private Long bookingItemId;
    private Long bookingId;
    private Long articleId;
    private Long fabricId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
}
