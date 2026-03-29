package com.tailorapp.order.service;

import com.tailorapp.order.dto.CreateOrderRequest;
import com.tailorapp.order.dto.OrderDTO;
import com.tailorapp.order.dto.OrderItemDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(CreateOrderRequest request);

    List<OrderDTO> getOrdersByUserId(Long userId);

    OrderDTO getOrderById(Long orderId);

    List<OrderItemDTO> getOrderItems(Long orderId);

    OrderDTO updateOrderStatus(Long orderId, String status);

    void cancelOrder(Long orderId);
}
