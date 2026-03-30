package com.tailorapp.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class CreateOrderRequest {

    @NotNull(message = "bookingId is required")
    private Long bookingId;
    private String notes;
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
