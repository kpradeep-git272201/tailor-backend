package com.tailorapp.catalog.cart.controller;

import com.tailorapp.catalog.cart.dto.AddToCartRequest;
import com.tailorapp.catalog.cart.dto.CartDTO;
import com.tailorapp.catalog.cart.service.CartService;
import com.tailorapp.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/catalog/api/v1/cart")
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CartDTO>> addToCart(@Valid @RequestBody AddToCartRequest request) {
        CartDTO cartDTO = cartService.addToCart(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Item added to cart successfully", cartDTO));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<CartDTO>>> getCartByUserId(@PathVariable Long userId) {
        List<CartDTO> cartItems = cartService.getCartByUserId(userId);

        if (cartItems == null || cartItems.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("Cart is empty", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Cart fetched successfully", cartItems, cartItems.size())
        );
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<ApiResponse<Void>> removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
        return ResponseEntity.ok(ApiResponse.success("Item removed from cart"));
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<ApiResponse<CartDTO>> updateCartItem(
            @PathVariable Long cartId,
            @Valid @RequestBody AddToCartRequest request) {
        CartDTO updatedCart = cartService.updateCartItem(cartId, request);
        return ResponseEntity.ok(ApiResponse.success("Cart item updated successfully", updatedCart));
    }
}
