package com.tailorapp.catalog.cart.service.impl;

import com.tailorapp.catalog.cart.dto.AddToCartRequest;
import com.tailorapp.catalog.cart.dto.CartDTO;
import com.tailorapp.catalog.cart.entity.CartEntity;
import com.tailorapp.catalog.cart.repository.CartRepository;
import com.tailorapp.catalog.cart.service.CartService;
import com.tailorapp.common.mapper.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartDTO addToCart(AddToCartRequest request) {
        Optional<CartEntity> existingItem = cartRepository.findByUserIdAndArticleIdAndFabricId(
                request.getUserId(),
                request.getArticleId(),
                request.getFabricId()
        );

        CartEntity cartEntity;
        if (existingItem.isPresent()) {
            cartEntity = existingItem.get();
            cartEntity.setQuantity(cartEntity.getQuantity() + request.getQuantity());
            if (request.getPrice() != null) {
                cartEntity.setPrice(request.getPrice());
            }
        } else {
            cartEntity = cartMapper.toEntity(request);
        }

        CartEntity savedEntity = cartRepository.save(cartEntity);
        return cartMapper.toDto(savedEntity);
    }

    @Override
    public List<CartDTO> getCartByUserId(Long userId) {
        List<CartEntity> cartEntities = cartRepository.findByUserId(userId);
        return cartMapper.toDtoList(cartEntities);
    }

    @Override
    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public CartDTO updateCartItem(Long cartId, AddToCartRequest request) {
        CartEntity cartEntity = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cartMapper.updateEntityFromRequest(request, cartEntity);
        CartEntity savedEntity = cartRepository.save(cartEntity);
        return cartMapper.toDto(savedEntity);
    }
}
