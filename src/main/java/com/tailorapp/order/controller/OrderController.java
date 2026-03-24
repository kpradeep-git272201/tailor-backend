package com.tailorapp.order.controller;

import com.tailorapp.common.response.ApiResponse;
import com.tailorapp.order.dto.CreateOrderRequest;
import com.tailorapp.order.dto.OrderDTO;
import com.tailorapp.order.dto.OrderItemDTO;
import com.tailorapp.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        OrderDTO order = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Order created successfully", order));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<OrderDTO>>> getOrdersByUserId(@PathVariable Long userId) {
        List<OrderDTO> orders = orderService.getOrdersByUserId(userId);

        if (orders == null || orders.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("No orders found", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Orders fetched successfully", orders, orders.size())
        );
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderDTO>> getOrderById(@PathVariable Long orderId) {
        OrderDTO order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(ApiResponse.success("Order fetched successfully", order));
    }

    @GetMapping("/{orderId}/items")
    public ResponseEntity<ApiResponse<List<OrderItemDTO>>> getOrderItems(@PathVariable Long orderId) {
        List<OrderItemDTO> items = orderService.getOrderItems(orderId);
        return ResponseEntity.ok(
                ApiResponse.success("Order items fetched successfully", items, items.size())
        );
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<ApiResponse<OrderDTO>> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {
        OrderDTO order = orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(ApiResponse.success("Order status updated successfully", order));
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<ApiResponse<Void>> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok(ApiResponse.success("Order cancelled successfully"));
    }
}
