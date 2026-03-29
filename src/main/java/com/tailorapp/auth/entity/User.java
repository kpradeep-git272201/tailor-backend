package com.tailorapp.auth.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "tailor")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(unique = true)
    private UUID uuid;

    @Column(unique = true, nullable = false)
    private String mobile;

    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true)
    private String email;

//    @Column(name = "address_json", columnDefinition = "jsonb")
//    private String addressJson;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "is_deleted")
    private String isDeleted;

    @PrePersist
    public void prePersist() {
        this.uuid = UUID.randomUUID();
        this.userId = "USR" + System.currentTimeMillis();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isActive = "Y";
        this.isDeleted = "N";
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

//    public String getAddressJson() {
//        return addressJson;
//    }
//
//    public void setAddressJson(String addressJson) {
//        this.addressJson = addressJson;
//    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
