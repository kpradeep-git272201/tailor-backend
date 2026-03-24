package com.tailorapp.auth.service;

import com.tailorapp.auth.dto.AuthResponse;
import com.tailorapp.auth.dto.LoginRequest;
import com.tailorapp.auth.dto.RegisterRequest;
import com.tailorapp.auth.dto.UserDTO;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    UserDTO getCurrentUser(Long userId);

    UserDTO updateProfile(Long userId, UserDTO userDTO);

    void changePassword(Long userId, String oldPassword, String newPassword);
}
