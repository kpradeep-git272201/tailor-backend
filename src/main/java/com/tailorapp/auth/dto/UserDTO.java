package com.tailorapp.auth.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long userId;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String role;
    private Boolean isActive;
    private Boolean emailVerified;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
}
