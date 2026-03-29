package com.tailorapp.booking.repository;

import com.tailorapp.booking.entity.BookingItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingItemRepository extends JpaRepository<BookingItemEntity, Long> {

    List<BookingItemEntity> findByBookingId(Long bookingId);
}
