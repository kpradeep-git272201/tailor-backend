package com.tailorapp.order.service.impl;

import com.tailorapp.booking.entity.BookingEntity;
import com.tailorapp.booking.entity.BookingItemEntity;
import com.tailorapp.booking.repository.BookingItemRepository;
import com.tailorapp.booking.repository.BookingRepository;
import com.tailorapp.common.mapper.OrderMapper;
import com.tailorapp.order.dto.CreateOrderRequest;
import com.tailorapp.order.dto.OrderDTO;
import com.tailorapp.order.dto.OrderItemDTO;
import com.tailorapp.order.entity.OrderEntity;
import com.tailorapp.order.entity.OrderItemEntity;
import com.tailorapp.order.repository.OrderItemRepository;
import com.tailorapp.order.repository.OrderRepository;
import com.tailorapp.order.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final BookingRepository bookingRepository;
    private final BookingItemRepository bookingItemRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemRepository orderItemRepository,
                            BookingRepository bookingRepository,
                            BookingItemRepository bookingItemRepository,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.bookingRepository = bookingRepository;
        this.bookingItemRepository = bookingItemRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public OrderDTO createOrder(CreateOrderRequest request) {
        BookingEntity booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        OrderEntity order = new OrderEntity();
        order.setBookingId(booking.getBookingId());
        order.setUserId(booking.getUserId());
        order.setStatus("PENDING");
        order.setPaymentStatus("PENDING");
        order.setDeliveryAddressId(booking.getAddressId());
        order.setTotalAmount(booking.getTotalAmount());
        order.setNotes(request.getNotes());
        order.setEstimatedDeliveryDate(LocalDateTime.now().plusDays(7));

        OrderEntity savedOrder = orderRepository.save(order);

        List<BookingItemEntity> bookingItems = bookingItemRepository.findByBookingId(booking.getBookingId());
        for (BookingItemEntity bookingItem : bookingItems) {
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setOrderId(savedOrder.getOrderId());
            orderItem.setArticleId(bookingItem.getArticleId());
            orderItem.setFabricId(bookingItem.getFabricId());
            orderItem.setMeasurementId(booking.getMeasurementId());
            orderItem.setQuantity(bookingItem.getQuantity());
            orderItem.setPrice(bookingItem.getPrice());
            orderItem.setSubtotal(bookingItem.getSubtotal());
            orderItem.setStatus("PENDING");

            orderItemRepository.save(orderItem);
        }

        booking.setStatus("CONFIRMED");
        bookingRepository.save(booking);

        return orderMapper.toDto(savedOrder);
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(Long userId) {
        List<OrderEntity> orders = orderRepository.findByUserIdOrderByCreatedAtDesc(userId);
        return orderMapper.toDtoList(orders);
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderItemDTO> getOrderItems(Long orderId) {
        List<OrderItemEntity> items = orderItemRepository.findByOrderId(orderId);
        return orderMapper.toItemDtoList(items);
    }

    @Override
    @Transactional
    public OrderDTO updateOrderStatus(Long orderId, String status) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        if ("DELIVERED".equals(status)) {
            order.setActualDeliveryDate(LocalDateTime.now());
        }

        OrderEntity savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus("CANCELLED");
        orderRepository.save(order);
    }
}
