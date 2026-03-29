package com.tailorapp.catalog.address.controller;

import com.tailorapp.catalog.address.dto.AddAddressRequest;
import com.tailorapp.catalog.address.dto.AddressDTO;
import com.tailorapp.catalog.address.service.AddressService;
import com.tailorapp.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/catalog/api/v1/address")
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AddressDTO>> addAddress(@Valid @RequestBody AddAddressRequest request) {
        AddressDTO addressDTO = addressService.addAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Address added successfully", addressDTO));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<AddressDTO>>> getAddressesByUserId(@PathVariable Long userId) {
        List<AddressDTO> addresses = addressService.getAddressesByUserId(userId);

        if (addresses == null || addresses.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("No addresses found", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Addresses fetched successfully", addresses, addresses.size())
        );
    }

    @GetMapping("/user/{userId}/default")
    public ResponseEntity<ApiResponse<AddressDTO>> getDefaultAddress(@PathVariable Long userId) {
        AddressDTO address = addressService.getDefaultAddress(userId);

        if (address == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("No default address found", "ADDRESS_NOT_FOUND"));
        }

        return ResponseEntity.ok(ApiResponse.success("Default address fetched successfully", address));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<ApiResponse<AddressDTO>> updateAddress(
            @PathVariable Long addressId,
            @Valid @RequestBody AddAddressRequest request) {
        AddressDTO updatedAddress = addressService.updateAddress(addressId, request);
        return ResponseEntity.ok(ApiResponse.success("Address updated successfully", updatedAddress));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<ApiResponse<Void>> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok(ApiResponse.success("Address deleted successfully"));
    }

    @PatchMapping("/user/{userId}/default/{addressId}")
    public ResponseEntity<ApiResponse<AddressDTO>> setDefaultAddress(
            @PathVariable Long userId,
            @PathVariable Long addressId) {
        AddressDTO address = addressService.setDefaultAddress(userId, addressId);
        return ResponseEntity.ok(ApiResponse.success("Default address set successfully", address));
    }
}
