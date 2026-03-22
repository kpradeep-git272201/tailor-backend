package com.tailorapp.catalog.address.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressDTO {

    private Long addressId;
    private Long userId;
    private String fullName;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String addressType;
    private Boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
