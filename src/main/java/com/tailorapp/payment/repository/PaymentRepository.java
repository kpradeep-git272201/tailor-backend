package com.tailorapp.payment.repository;

import com.tailorapp.payment.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    Optional<PaymentEntity> findByOrderId(Long orderId);

    Optional<PaymentEntity> findByTransactionId(String transactionId);

    Optional<PaymentEntity> findByGatewayOrderId(String gatewayOrderId);

    List<PaymentEntity> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<PaymentEntity> findByStatus(String status);
}
