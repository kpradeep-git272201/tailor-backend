package com.tailorapp.catalog.address.service;

import com.tailorapp.catalog.address.dto.AddAddressRequest;
import com.tailorapp.catalog.address.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    AddressDTO addAddress(AddAddressRequest request);

    List<AddressDTO> getAddressesByUserId(Long userId);

    AddressDTO getDefaultAddress(Long userId);

    AddressDTO updateAddress(Long addressId, AddAddressRequest request);

    void deleteAddress(Long addressId);

    AddressDTO setDefaultAddress(Long userId, Long addressId);
}
