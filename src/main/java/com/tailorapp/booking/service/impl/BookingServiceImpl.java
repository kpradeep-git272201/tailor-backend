package com.tailorapp.booking.service.impl;

import com.tailorapp.booking.dto.BookingDTO;
import com.tailorapp.booking.dto.BookingItemDTO;
import com.tailorapp.booking.dto.CreateBookingRequest;
import com.tailorapp.booking.entity.BookingEntity;
import com.tailorapp.booking.entity.BookingItemEntity;
import com.tailorapp.booking.repository.BookingItemRepository;
import com.tailorapp.booking.repository.BookingRepository;
import com.tailorapp.booking.service.BookingService;
import com.tailorapp.catalog.cart.entity.CartEntity;
import com.tailorapp.catalog.cart.repository.CartRepository;
import com.tailorapp.common.mapper.BookingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingItemRepository bookingItemRepository;
    private final CartRepository cartRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              BookingItemRepository bookingItemRepository,
                              CartRepository cartRepository,
                              BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingItemRepository = bookingItemRepository;
        this.cartRepository = cartRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    @Transactional
    public BookingDTO createBooking(CreateBookingRequest request) {
        BookingEntity booking = new BookingEntity();
        booking.setUserId(request.getUserId());
        booking.setTailorId(request.getTailorId());
        booking.setAddressId(request.getAddressId());
        booking.setMeasurementId(request.getMeasurementId());
        booking.setBookingDate(request.getBookingDate());
        booking.setBookingTime(request.getBookingTime());
        booking.setNotes(request.getNotes());
        booking.setStatus("PENDING");

        BookingEntity savedBooking = bookingRepository.save(booking);

        if (request.getCartItemIds() != null && !request.getCartItemIds().isEmpty()) {
            List<CartEntity> cartItems = cartRepository.findAllById(request.getCartItemIds());
            BigDecimal totalAmount = BigDecimal.ZERO;

            for (CartEntity cartItem : cartItems) {
                BookingItemEntity bookingItem = new BookingItemEntity();
                bookingItem.setBookingId(savedBooking.getBookingId());
                bookingItem.setArticleId(cartItem.getArticleId());
                bookingItem.setFabricId(cartItem.getFabricId());
                bookingItem.setQuantity(cartItem.getQuantity());
                bookingItem.setPrice(cartItem.getPrice());
                
                BigDecimal subtotal = cartItem.getPrice() != null ? 
                    cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())) : BigDecimal.ZERO;
                bookingItem.setSubtotal(subtotal);
                
                bookingItemRepository.save(bookingItem);
                totalAmount = totalAmount.add(subtotal);
            }

            savedBooking.setTotalAmount(totalAmount);
            savedBooking = bookingRepository.save(savedBooking);

            cartRepository.deleteAll(cartItems);
        }

        return bookingMapper.toDto(savedBooking);
    }

    @Override
    public List<BookingDTO> getBookingsByUserId(Long userId) {
        List<BookingEntity> bookings = bookingRepository.findByUserIdOrderByCreatedAtDesc(userId);
        return bookingMapper.toDtoList(bookings);
    }

    @Override
    public BookingDTO getBookingById(Long bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return bookingMapper.toDto(booking);
    }

    @Override
    public List<BookingItemDTO> getBookingItems(Long bookingId) {
        List<BookingItemEntity> items = bookingItemRepository.findByBookingId(bookingId);
        return bookingMapper.toItemDtoList(items);
    }

    @Override
    @Transactional
    public BookingDTO updateBookingStatus(Long bookingId, String status) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        booking.setStatus(status);
        BookingEntity savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDto(savedBooking);
    }

    @Override
    @Transactional
    public BookingDTO rescheduleBooking(Long bookingId, CreateBookingRequest request) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setBookingDate(request.getBookingDate());
        booking.setBookingTime(request.getBookingTime());
        
        BookingEntity savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDto(savedBooking);
    }

    @Override
    @Transactional
    public void cancelBooking(Long bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }
}
