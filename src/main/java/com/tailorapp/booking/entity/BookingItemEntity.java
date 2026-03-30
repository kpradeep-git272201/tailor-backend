package com.tailorapp.booking.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
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

    public Long getBookingItemId() {
        return bookingItemId;
    }

    public void setBookingItemId(Long bookingItemId) {
        this.bookingItemId = bookingItemId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getFabricId() {
        return fabricId;
    }

    public void setFabricId(Long fabricId) {
        this.fabricId = fabricId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
