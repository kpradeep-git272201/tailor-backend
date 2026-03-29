package com.tailorapp.auth.service.impl;

import com.tailorapp.auth.dto.AuthResponse;
import com.tailorapp.auth.dto.LoginRequest;
import com.tailorapp.auth.dto.RegisterRequest;
import com.tailorapp.auth.dto.UserDTO;
import com.tailorapp.auth.entity.UserEntity;
import com.tailorapp.auth.repository.UserRepository;
import com.tailorapp.auth.service.AuthService;
import com.tailorapp.common.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        UserEntity user = userMapper.toEntity(request);
        user.setPasswordHash(hashPassword(request.getPassword()));

        UserEntity savedUser = userRepository.save(user);

        String token = generateToken(savedUser);
        String refreshToken = generateRefreshToken(savedUser);

        return new AuthResponse(
                token,
                refreshToken,
                savedUser.getUserId(),
                savedUser.getEmail(),
                savedUser.getFullName(),
                savedUser.getRole()
        );
    }

    @Override
    @Transactional
    public AuthResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByEmailAndIsActiveTrue(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!verifyPassword(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid email or password");
        }

        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        String token = generateToken(user);
        String refreshToken = generateRefreshToken(user);

        return new AuthResponse(
                token,
                refreshToken,
                user.getUserId(),
                user.getEmail(),
                user.getFullName(),
                user.getRole()
        );
    }

    @Override
    public UserDTO getCurrentUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserDTO updateProfile(Long userId, UserDTO userDTO) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userDTO.getFullName() != null) {
            user.setFullName(userDTO.getFullName());
        }
        if (userDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(userDTO.getPhoneNumber());
        }

        UserEntity savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!verifyPassword(oldPassword, user.getPasswordHash())) {
            throw new RuntimeException("Current password is incorrect");
        }

        user.setPasswordHash(hashPassword(newPassword));
        userRepository.save(user);
    }

    private String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private boolean verifyPassword(String rawPassword, String hashedPassword) {
        String hashed = hashPassword(rawPassword);
        return hashed.equals(hashedPassword);
    }

    private String generateToken(UserEntity user) {
        return Base64.getEncoder().encodeToString(
                (user.getUserId() + ":" + user.getEmail() + ":" + System.currentTimeMillis()).getBytes()
        );
    }

    private String generateRefreshToken(UserEntity user) {
        return Base64.getEncoder().encodeToString(
                (user.getUserId() + ":refresh:" + System.currentTimeMillis()).getBytes()
        );
    }
}
