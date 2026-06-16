package com.tailorapp.common.mapper;

import com.tailorapp.catalog.cart.dto.AddToCartRequest;
import com.tailorapp.catalog.cart.dto.CartDTO;
import com.tailorapp.catalog.cart.entity.CartEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartDTO toDto(CartEntity entity) {
        if (entity == null) return null;

        CartDTO dto = new CartDTO();
        dto.setCartId(entity.getCartId());
        dto.setUserId(entity.getUserId());
        dto.setArticleId(entity.getArticleId());
        dto.setFabricId(entity.getFabricId());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public List<CartDTO> toDtoList(List<CartEntity> entities) {
        if (entities == null) return Collections.emptyList();
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public CartEntity toEntity(CartDTO dto) {
        if (dto == null) return null;

        CartEntity entity = new CartEntity();
        entity.setCartId(dto.getCartId());
        entity.setUserId(dto.getUserId());
        entity.setArticleId(dto.getArticleId());
        entity.setFabricId(dto.getFabricId());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public CartEntity toEntity(AddToCartRequest request) {
        if (request == null) return null;

        CartEntity entity = new CartEntity();
        entity.setUserId(request.getUserId());
        entity.setArticleId(request.getArticleId());
        entity.setFabricId(request.getFabricId());
        entity.setQuantity(request.getQuantity());
        entity.setPrice(request.getPrice());
        return entity;
    }

    public void updateEntityFromRequest(AddToCartRequest request, CartEntity entity) {
        if (request == null) return;

        if (request.getUserId() != null) entity.setUserId(request.getUserId());
        if (request.getArticleId() != null) entity.setArticleId(request.getArticleId());
        if (request.getFabricId() != null) entity.setFabricId(request.getFabricId());
        if (request.getQuantity() != null) entity.setQuantity(request.getQuantity());
        if (request.getPrice() != null) entity.setPrice(request.getPrice());
    }
}
