package com.tailorapp.auth.controller;

import com.tailorapp.auth.dto.AuthResponse;
import com.tailorapp.auth.dto.LoginRequest;
import com.tailorapp.auth.dto.RegisterRequest;
import com.tailorapp.auth.dto.UserDTO;
import com.tailorapp.auth.service.AuthService;
import com.tailorapp.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("User registered successfully", response));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(ApiResponse.success("Login successful", response));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserDTO>> getCurrentUser(@RequestHeader("X-User-Id") Long userId) {
        UserDTO user = authService.getCurrentUser(userId);
        return ResponseEntity.ok(ApiResponse.success("User fetched successfully", user));
    }

    @PutMapping("/me")
    public ResponseEntity<ApiResponse<UserDTO>> updateProfile(
            @RequestHeader("X-User-Id") Long userId,
            @Valid @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = authService.updateProfile(userId, userDTO);
        return ResponseEntity.ok(ApiResponse.success("Profile updated successfully", updatedUser));
    }
}
