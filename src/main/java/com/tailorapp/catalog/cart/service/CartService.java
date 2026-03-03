package com.tailorapp.catalog.cart.service;

import com.tailorapp.catalog.cart.dto.AddToCartRequest;
import com.tailorapp.catalog.cart.dto.CartDTO;

import java.util.List;

public interface CartService {

    CartDTO addToCart(AddToCartRequest request);

    List<CartDTO> getCartByUserId(Long userId);

    void removeFromCart(Long cartId);

    CartDTO updateCartItem(Long cartId, AddToCartRequest request);
}
