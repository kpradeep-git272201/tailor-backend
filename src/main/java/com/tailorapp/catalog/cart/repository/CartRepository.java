package com.tailorapp.catalog.cart.repository;

import com.tailorapp.catalog.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    List<CartEntity> findByUserId(Long userId);

    Optional<CartEntity> findByUserIdAndArticleIdAndFabricId(Long userId, Long articleId, Long fabricId);
}
