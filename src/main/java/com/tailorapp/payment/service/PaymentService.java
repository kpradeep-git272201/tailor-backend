package com.tailorapp.payment.service;

import com.tailorapp.payment.dto.CreatePaymentRequest;
import com.tailorapp.payment.dto.PaymentDTO;
import com.tailorapp.payment.dto.VerifyPaymentRequest;

import java.util.List;

public interface PaymentService {

    PaymentDTO createPaymentOrder(CreatePaymentRequest request);

    PaymentDTO verifyPayment(VerifyPaymentRequest request);

    PaymentDTO getPaymentById(Long paymentId);

    PaymentDTO getPaymentByOrderId(Long orderId);

    List<PaymentDTO> getPaymentsByUserId(Long userId);

    PaymentDTO refundPayment(Long paymentId);
}
