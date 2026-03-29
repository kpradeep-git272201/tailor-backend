package com.tailorapp.booking.service;

import com.tailorapp.booking.dto.BookingDTO;
import com.tailorapp.booking.dto.BookingItemDTO;
import com.tailorapp.booking.dto.CreateBookingRequest;

import java.util.List;

public interface BookingService {

    BookingDTO createBooking(CreateBookingRequest request);

    List<BookingDTO> getBookingsByUserId(Long userId);

    BookingDTO getBookingById(Long bookingId);

    List<BookingItemDTO> getBookingItems(Long bookingId);

    BookingDTO updateBookingStatus(Long bookingId, String status);

    BookingDTO rescheduleBooking(Long bookingId, CreateBookingRequest request);

    void cancelBooking(Long bookingId);
}
