package com.tailorapp.booking.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "booking_items", schema = DatabaseConstants.TAILOR)
public class BookingItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_item_id")
    private Long bookingItemId;

    @Column(name = "booking_id", nullable = false)
    private Long bookingId;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "fabric_id")
    private Long fabricId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity = 1;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;
}
