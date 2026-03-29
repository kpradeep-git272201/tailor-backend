package com.tailorapp.payment.controller;

import com.tailorapp.common.response.ApiResponse;
import com.tailorapp.payment.dto.CreatePaymentRequest;
import com.tailorapp.payment.dto.PaymentDTO;
import com.tailorapp.payment.dto.VerifyPaymentRequest;
import com.tailorapp.payment.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/payments")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<ApiResponse<PaymentDTO>> createPaymentOrder(@Valid @RequestBody CreatePaymentRequest request) {
        PaymentDTO payment = paymentService.createPaymentOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Payment order created successfully", payment));
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiResponse<PaymentDTO>> verifyPayment(@Valid @RequestBody VerifyPaymentRequest request) {
        PaymentDTO payment = paymentService.verifyPayment(request);
        return ResponseEntity.ok(ApiResponse.success("Payment verified successfully", payment));
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<ApiResponse<PaymentDTO>> getPaymentById(@PathVariable Long paymentId) {
        PaymentDTO payment = paymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(ApiResponse.success("Payment fetched successfully", payment));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ApiResponse<PaymentDTO>> getPaymentByOrderId(@PathVariable Long orderId) {
        PaymentDTO payment = paymentService.getPaymentByOrderId(orderId);
        return ResponseEntity.ok(ApiResponse.success("Payment fetched successfully", payment));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<PaymentDTO>>> getPaymentsByUserId(@PathVariable Long userId) {
        List<PaymentDTO> payments = paymentService.getPaymentsByUserId(userId);

        if (payments == null || payments.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("No payments found", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Payments fetched successfully", payments, payments.size())
        );
    }

    @PostMapping("/{paymentId}/refund")
    public ResponseEntity<ApiResponse<PaymentDTO>> refundPayment(@PathVariable Long paymentId) {
        PaymentDTO payment = paymentService.refundPayment(paymentId);
        return ResponseEntity.ok(ApiResponse.success("Payment refunded successfully", payment));
    }
}
