package com.tailorapp.auth.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

public class UserDTO {

    private Long userId;
    private String phoneNumber;
    private String fullName;
    private String email;
    private String role;
    private Boolean isActive;

    @Column(columnDefinition = "jsonb")
    private String addressJson;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setAddressJson(String addressJson) {
        this.addressJson = addressJson;
    }

    public String getAddressJson() {
        return addressJson;
    }
}