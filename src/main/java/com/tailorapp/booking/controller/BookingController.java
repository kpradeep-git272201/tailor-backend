package com.tailorapp.booking.controller;

import com.tailorapp.booking.dto.BookingDTO;
import com.tailorapp.booking.dto.BookingItemDTO;
import com.tailorapp.booking.dto.CreateBookingRequest;
import com.tailorapp.booking.service.BookingService;
import com.tailorapp.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/bookings")
@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookingDTO>> createBooking(@Valid @RequestBody CreateBookingRequest request) {
        BookingDTO booking = bookingService.createBooking(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Booking created successfully", booking));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<BookingDTO>>> getBookingsByUserId(@PathVariable Long userId) {
        List<BookingDTO> bookings = bookingService.getBookingsByUserId(userId);

        if (bookings == null || bookings.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("No bookings found", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Bookings fetched successfully", bookings, bookings.size())
        );
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<ApiResponse<BookingDTO>> getBookingById(@PathVariable Long bookingId) {
        BookingDTO booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(ApiResponse.success("Booking fetched successfully", booking));
    }

    @GetMapping("/{bookingId}/items")
    public ResponseEntity<ApiResponse<List<BookingItemDTO>>> getBookingItems(@PathVariable Long bookingId) {
        List<BookingItemDTO> items = bookingService.getBookingItems(bookingId);
        return ResponseEntity.ok(
                ApiResponse.success("Booking items fetched successfully", items, items.size())
        );
    }

    @PatchMapping("/{bookingId}/status")
    public ResponseEntity<ApiResponse<BookingDTO>> updateBookingStatus(
            @PathVariable Long bookingId,
            @RequestParam String status) {
        BookingDTO booking = bookingService.updateBookingStatus(bookingId, status);
        return ResponseEntity.ok(ApiResponse.success("Booking status updated successfully", booking));
    }

    @PatchMapping("/{bookingId}/reschedule")
    public ResponseEntity<ApiResponse<BookingDTO>> rescheduleBooking(
            @PathVariable Long bookingId,
            @Valid @RequestBody CreateBookingRequest request) {
        BookingDTO booking = bookingService.rescheduleBooking(bookingId, request);
        return ResponseEntity.ok(ApiResponse.success("Booking rescheduled successfully", booking));
    }

    @PatchMapping("/{bookingId}/cancel")
    public ResponseEntity<ApiResponse<Void>> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(ApiResponse.success("Booking cancelled successfully"));
    }
}
