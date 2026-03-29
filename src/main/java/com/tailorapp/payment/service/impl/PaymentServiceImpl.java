package com.tailorapp.payment.service.impl;

import com.tailorapp.common.mapper.PaymentMapper;
import com.tailorapp.order.entity.OrderEntity;
import com.tailorapp.order.repository.OrderRepository;
import com.tailorapp.payment.dto.CreatePaymentRequest;
import com.tailorapp.payment.dto.PaymentDTO;
import com.tailorapp.payment.dto.VerifyPaymentRequest;
import com.tailorapp.payment.entity.PaymentEntity;
import com.tailorapp.payment.repository.PaymentRepository;
import com.tailorapp.payment.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              OrderRepository orderRepository,
                              PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    @Transactional
    public PaymentDTO createPaymentOrder(CreatePaymentRequest request) {
        OrderEntity order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        PaymentEntity payment = new PaymentEntity();
        payment.setOrderId(order.getOrderId());
        payment.setUserId(order.getUserId());
        payment.setAmount(request.getAmount());
        payment.setCurrency(request.getCurrency());
        payment.setPaymentGateway(request.getPaymentGateway());
        payment.setStatus("PENDING");
        payment.setTransactionId("TXN" + System.currentTimeMillis());
        payment.setGatewayOrderId("order_" + UUID.randomUUID().toString().substring(0, 8));

        PaymentEntity savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDto(savedPayment);
    }

    @Override
    @Transactional
    public PaymentDTO verifyPayment(VerifyPaymentRequest request) {
        PaymentEntity payment = paymentRepository.findByGatewayOrderId(request.getGatewayOrderId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setGatewayPaymentId(request.getGatewayPaymentId());
        payment.setGatewaySignature(request.getGatewaySignature());
        payment.setStatus("SUCCESS");
        payment.setCompletedAt(LocalDateTime.now());

        PaymentEntity savedPayment = paymentRepository.save(payment);

        OrderEntity order = orderRepository.findById(payment.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setPaymentStatus("PAID");
        orderRepository.save(order);

        return paymentMapper.toDto(savedPayment);
    }

    @Override
    public PaymentDTO getPaymentById(Long paymentId) {
        PaymentEntity payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return paymentMapper.toDto(payment);
    }

    @Override
    public PaymentDTO getPaymentByOrderId(Long orderId) {
        PaymentEntity payment = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found for this order"));
        return paymentMapper.toDto(payment);
    }

    @Override
    public List<PaymentDTO> getPaymentsByUserId(Long userId) {
        List<PaymentEntity> payments = paymentRepository.findByUserIdOrderByCreatedAtDesc(userId);
        return paymentMapper.toDtoList(payments);
    }

    @Override
    @Transactional
    public PaymentDTO refundPayment(Long paymentId) {
        PaymentEntity payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (!"SUCCESS".equals(payment.getStatus())) {
            throw new RuntimeException("Only successful payments can be refunded");
        }

        payment.setStatus("REFUNDED");
        PaymentEntity savedPayment = paymentRepository.save(payment);

        OrderEntity order = orderRepository.findById(payment.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setPaymentStatus("REFUNDED");
        orderRepository.save(order);

        return paymentMapper.toDto(savedPayment);
    }
}
