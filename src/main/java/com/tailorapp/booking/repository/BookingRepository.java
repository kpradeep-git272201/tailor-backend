package com.tailorapp.booking.repository;

import com.tailorapp.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    List<BookingEntity> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<BookingEntity> findByTailorIdOrderByBookingDateDesc(Long tailorId);

    List<BookingEntity> findByStatus(String status);
}
